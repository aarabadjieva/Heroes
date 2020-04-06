package app.service;

import app.domain.entity.User;
import app.domain.model.binding.UserLoginBinding;
import app.domain.model.service.UserServiceModel;
import app.repository.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Inject
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void register(UserServiceModel user) {
        user.setPassword(DigestUtils.sha256Hex(user.getPassword()));
        userRepository.save(modelMapper.map(user, User.class));
    }

    @Override
    public UserServiceModel login(UserLoginBinding user) {
        try {
            return modelMapper.map(userRepository
                    .findByNameAndPassword(user.getUsername(), DigestUtils.sha256Hex(user.getPassword())), UserServiceModel.class);
        } catch (Exception e) {
            return null;
        }
    }
}


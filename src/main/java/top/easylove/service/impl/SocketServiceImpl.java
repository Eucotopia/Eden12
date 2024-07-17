package top.easylove.service.impl;

import jakarta.annotation.Resource;
import jakarta.mail.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import top.easylove.constant.RabbitMQConstants;
import top.easylove.enums.ResultEnum;
import top.easylove.pojo.MessageType;
import top.easylove.pojo.dto.UserDto;
import top.easylove.service.ISocketService;
import top.easylove.util.ResultResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class SocketServiceImpl implements ISocketService {
    @Resource
    private RabbitTemplate rabbitTemplate;

    @Override
    public ResultResponse<List<MessageType>> getUnapprovedUsers() {
        rabbitTemplate.convertAndSend(RabbitMQConstants.USER_REGISTRATION_QUEUE, new UserDto());
        List<MessageType> messageTypes = new ArrayList<MessageType>();
        MessageType messageType = new MessageType("1","1","1","1","1");
        MessageType messageType1 = new MessageType("1","1","1","1","1");
        MessageType messageType2 = new MessageType("1","1","1","1","1");
        MessageType messageType3 = new MessageType("1","1","1","1","1");
        messageTypes.add(messageType);
        messageTypes.add(messageType1);
        messageTypes.add(messageType2);
        messageTypes.add(messageType3);

        return ResultResponse.success(ResultEnum.SUCCESS,messageTypes);
    }
}

package bridge.service;

import static org.junit.jupiter.api.Assertions.*;

import bridge.BeanFactory;
import bridge.domain.Bridge;
import bridge.domain.Move;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    BeanFactory factory;
    @BeforeEach
    void setUp(){
        factory = new BeanFactory();
    }

}
package com.utc.chatbot.service.impl;

import com.utc.chatbot.entity.database.Customer;
import com.utc.chatbot.repository.CoupleRepository;
import com.utc.chatbot.repository.CustomerRepository;
import com.utc.chatbot.service.CustomerService;
import com.utc.chatbot.utils.CallApi;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

import java.io.IOException;

@RunWith(MockitoJUnitRunner.class)
public class CoupleServiceImplTest {

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    public CustomerService customerService;

    @Mock
    public CallApi callApi;

    @Mock
    public CoupleRepository coupleRepository;

    @Mock
    public CustomerRepository customerRepository;

    @InjectMocks
    public CoupleServiceImpl coupleService;

    @Test
    public void saveCouple() throws IOException {
        Customer customer = new Customer();
        customer.setIdMessenger("3323323");
        when(customerRepository.findByIdMessenger("3323323")).thenReturn(customer);
        when(coupleRepository.findByIdMessSecond(null)).thenReturn(null);
        verify(callApi).sendNotify("3323323", "", "dđ");
    }

}

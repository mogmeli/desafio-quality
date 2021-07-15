package com.example.desafioquality.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//@ExtendWith(MockitoExtension.class)
//public class VerifyDistrictExistServiceTest {
//
//    @Mock
//    private DistrictRepository fakeDistrictRepository;
//
//    private VerifyDistrictExistService underTest;
//
//    @BeforeEach
//    void setUp() {
//        underTest = new VerifyDistrictExistService(fakeDistrictRepository);
//    }
//
//    @Test
//    public void deveExplodirUmaExcecao_QuandoBuscarPorUmBairroQueNaoExiste(){
//
//        when(fakeDistrictRepository.findByName(any())).thenReturn(Optional.empty());
//
//        assertThrows(DistrictDoesntExistException.class, () -> underTest.verifyByName("Bugeda"));
//
//    }
//
//    @Test
//    public void deveRetornarTrue_QuandoBuscarPorUmBairroQueExiste(){
//
//        when(fakeDistrictRepository.findByName(any())).thenReturn(Optional. of(new District()));
//
//        assertTrue(underTest.verifyByName("Bugeda"));
//
//    }
//
//
//
//}
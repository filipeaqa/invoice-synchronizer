package com.api.challenge.invoicesynchronizer.service;

import com.api.challenge.invoicesynchronizer.entity.InvoiceEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class InvoiceServiceTest {

    @Autowired
    InvoiceService service;

    @Test
    public void shouldPersistEntities() {

        List<InvoiceEntity> entities = new ArrayList<>();
        entities.add(new InvoiceEntity());
        entities.add(new InvoiceEntity());

        final List<InvoiceEntity> persisted = service.saveAll(entities);

        Assert.assertNotNull(persisted);
        Assert.assertEquals(Long.valueOf(1L), persisted.get(0).getId());
        Assert.assertEquals(Long.valueOf(2L), persisted.get(1).getId());
    }



}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.examen.nosql.config;

import ch.qos.logback.core.pattern.Converter;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import java.math.BigDecimal;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.Decimal128;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author cofre
 */

@Component
@Slf4j
public class MongoConfig extends AbstractMongoClientConfiguration {
    @Autowired
    private ApplicationValues appValues;
    
    @Override
    protected String getDatabaseName() {
        return this.appValues.getMongoDB();
    }

    @Override
    public MongoClient mongoClient() {
        log.info("Valores de propiedades: {}/{}",this.appValues.getMongoHost(), this.appValues.getMongoDB());
        return MongoClients.create("mongodb://"+ this.appValues.getMongoHost() + "/" + this.appValues.getMongoDB());
    }
    
    @Bean
    @Override
    public MappingMongoConverter mappingMongoConverter(MongoDatabaseFactory databaseFactory, MongoCustomConversions customConversions, MongoMappingContext mappingContext) {
        MappingMongoConverter converter = super.mappingMongoConverter(databaseFactory, customConversions, mappingContext);
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
        return converter;
    }
    
    /**
     * Inject a CustomConversions bean to overwrite the default mapping
     * of BigDecimal.
     * 
     * @return a new instance of CustomConversons
     */
    @Bean
    @Override
    public MongoCustomConversions customConversions() {
        org.springframework.core.convert.converter.Converter<Decimal128, BigDecimal> decimal128ToBigDecimal = new org.springframework.core.convert.converter.Converter<>() {
            @Override
            public BigDecimal convert(Decimal128 s) {
                return s==null ? null : s.bigDecimalValue();
            }
        };
        
        org.springframework.core.convert.converter.Converter<BigDecimal, Decimal128> bigDecimalToDecimal128 = new org.springframework.core.convert.converter.Converter<>() {
            @Override
            public Decimal128 convert(BigDecimal s) {
                return s==null ? null : new Decimal128(s);
            }
        };
        
        return new MongoCustomConversions(Arrays.asList(decimal128ToBigDecimal, bigDecimalToDecimal128));
    }
}

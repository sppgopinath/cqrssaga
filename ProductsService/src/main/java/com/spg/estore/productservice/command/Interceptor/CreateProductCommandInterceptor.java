package com.spg.estore.productservice.command.Interceptor;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.BiFunction;

import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.messaging.MessageDispatchInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spg.estore.productservice.command.CreateProductCommand;
import com.spg.estore.productservice.core.data.ProductLookUpEntity;
import com.spg.estore.productservice.core.repository.ProductLookUpRepository;

@Component
public class CreateProductCommandInterceptor implements MessageDispatchInterceptor<CommandMessage<?>> {

	private static final Logger log = LoggerFactory.getLogger(CreateProductCommandInterceptor.class);

	@Autowired
	ProductLookUpRepository productLookUpRepository;
	@Override
	public BiFunction<Integer, CommandMessage<?>, CommandMessage<?>> handle(
			List<? extends CommandMessage<?>> messages) {
		return (index, command) -> {
			if (CreateProductCommand.class.equals(command.getPayloadType())) {
				log.info("Interceptor command" + command.getPayloadType());
				CreateProductCommand createProductCommand = (CreateProductCommand) command.getPayload();
				ProductLookUpEntity productLookUpEntity = productLookUpRepository.findByProductIdOrTitle(createProductCommand.getProductId(), createProductCommand.getTitle());
				
				if(productLookUpEntity!=null) {
					throw new IllegalStateException(String.format("Product with product Id %s or title %s already exists",createProductCommand.getProductId(),createProductCommand.getTitle()));
				}
			/*	if (createProductCommand.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
					throw new IllegalArgumentException("Price can not be less or equal to zero");
				}
				if (createProductCommand.getTitle() == null || createProductCommand.getTitle().isBlank()) {
					throw new IllegalArgumentException("Title can not be empty");
				}*/
			}
			return command;
		};
	}

}

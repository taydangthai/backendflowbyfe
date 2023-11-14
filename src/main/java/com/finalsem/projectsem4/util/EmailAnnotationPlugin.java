package com.finalsem.projectsem4.util;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import springfox.bean.validators.plugins.Validators;
import springfox.documentation.builders.StringElementFacetBuilder;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.schema.ModelPropertyBuilderPlugin;
import springfox.documentation.spi.schema.contexts.ModelPropertyContext;

import javax.validation.constraints.Email;

import java.util.Optional;

import static springfox.bean.validators.plugins.Validators.annotationFromBean;

/**
 * @author Ly Quoc Trong
 */
@Component
@Order(Validators.BEAN_VALIDATOR_PLUGIN_ORDER)
public class EmailAnnotationPlugin implements ModelPropertyBuilderPlugin {
    @Override
    public void apply(ModelPropertyContext context) {
        Optional<Email> email = annotationFromBean(context, Email.class);
        if (email.isPresent()) {
            context.getSpecificationBuilder().facetBuilder(StringElementFacetBuilder.class)
                    .pattern(email.get().regexp());
            context.getSpecificationBuilder().example("email@email.com");
        }
    }

    @Override
    public boolean supports(DocumentationType documentationType) {
        return true;
    }
}

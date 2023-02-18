package org.example;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.domain.JavaModifier;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.jupiter.api.Test;

public class HexagonalArchitectureTest {

    private final JavaClasses classes = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("org.example");

    @Test
    void domainLayerShouldNotDependOnInfrastructureLayer() {
        ArchRule rule = ArchRuleDefinition.noClasses()
                .that().resideInAPackage("..domain..")
                .should().dependOnClassesThat().resideInAPackage("..infrastructure..");
        rule.check(classes);
    }

    @Test
    void applicationLayerShouldOnlyDependOnDomainLayer() {
        ArchRule rule = ArchRuleDefinition.classes()
                .that().resideInAPackage("..application..")
                .should().onlyDependOnClassesThat().resideInAPackage("..domain..");
        rule.check(classes);
    }

    @Test
    void infrastructureLayerShouldNotDependOnOtherLayers() {
        ArchRule rule = ArchRuleDefinition.noClasses()
                .that().resideInAPackage("..infrastructure..")
                .and().haveModifier(JavaModifier.PUBLIC)
                .should().dependOnClassesThat().resideOutsideOfPackage("..infrastructure..");
        rule.check(classes);
    }

}

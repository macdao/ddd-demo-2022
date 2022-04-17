package com.example.demo;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.plantuml.PlantUmlArchCondition.Configurations.consideringOnlyDependenciesInAnyPackage;
import static com.tngtech.archunit.library.plantuml.PlantUmlArchCondition.adhereToPlantUmlDiagram;

@AnalyzeClasses(packages = "com.example.demo")
public class ArchUnitTest {
    @ArchTest
    public static final ArchRule archRule = classes()
            .should(adhereToPlantUmlDiagram(ArchUnitTest.class.getResource("/arch-diagram.puml"), consideringOnlyDependenciesInAnyPackage("com.example.demo..")));
}

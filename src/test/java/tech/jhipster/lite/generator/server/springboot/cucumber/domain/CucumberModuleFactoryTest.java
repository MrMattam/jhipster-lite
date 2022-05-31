package tech.jhipster.lite.generator.server.springboot.cucumber.domain;

import static tech.jhipster.lite.generator.module.infrastructure.secondary.JHipsterModulesAssertions.*;

import org.junit.jupiter.api.Test;
import tech.jhipster.lite.UnitTest;
import tech.jhipster.lite.common.domain.FileUtils;
import tech.jhipster.lite.generator.module.domain.JHipsterModule;

@UnitTest
class CucumberModuleFactoryTest {

  private static final CucumberModuleFactory factory = new CucumberModuleFactory();

  @Test
  void shouldCreateModule() {
    CucumberModuleProperties properties = CucumberModuleProperties
      .builder()
      .project(FileUtils.tmpDirForTest())
      .basePackage("com.jhipster.test")
      .projectBaseName("myapp")
      .build();

    JHipsterModule module = factory.buildModule(properties);

    assertThatModuleOnProjectWithDefaultPom(module)
      .createPrefixedFiles(
        "src/test/java/com/jhipster/test/cucumber",
        "AsyncElementAsserter.java",
        "AsyncHeaderAsserter.java",
        "AsyncResponseAsserter.java",
        "Awaiter.java",
        "CucumberAssertions.java",
        "CucumberConfiguration.java",
        "CucumberJson.java",
        "CucumberTest.java",
        "CucumberTestContext.java",
        "CucumberTestContextUnitTest.java",
        "ElementAsserter.java",
        "ElementAssertions.java",
        "HeaderAsserter.java",
        "HeaderAssertions.java",
        "ResponseAsserter.java",
        "SyncElementAsserter.java",
        "SyncHeaderAsserter.java",
        "SyncResponseAsserter.java"
      )
      .createFile("documentation/cucumber.md")
      .and()
      .createFile("src/test/features/.gitkeep")
      .and()
      .createFile("pom.xml")
      .containing("<artifactId>cucumber-junit</artifactId>")
      .containing("<artifactId>cucumber-java</artifactId>")
      .containing("<artifactId>cucumber-spring</artifactId>")
      .containing("<artifactId>junit-vintage-engine</artifactId>")
      .containing("<artifactId>testng</artifactId>")
      .containing("<artifactId>awaitility</artifactId>")
      .containing("<version>${cucumber.version}</version>");
  }
}
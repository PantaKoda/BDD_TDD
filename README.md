# Bank APP BDD TDD practice

This project is for practicing  BDD TDD methods using `Cucumber` with `Junit5`. We implemented tests mostly. The main code is just simple implementations so the tests have something to test.

## Implementation Overview

- **Cucumber**: Features are located in `src/Test/Resources/features` and the relevant step functions at `src/Test/Java/steps` directory. We tried to logically split the feature files based or group together scenarios in one feature file. There is also the `src/Test/Java/runner` directory which contains integration of Cucumber with Junit as shown [here](https://github.com/cucumber/cucumber-jvm/tree/main/cucumber-junit-platform-engine) . Also
- **Junit**:  unit tests are found inside `src/Test/Java` 
- **Main Code** : Actual functionality implementation is superficial. It exists only so the tests can run. 

## Testing 

By running `mvn test` it will run the tests.

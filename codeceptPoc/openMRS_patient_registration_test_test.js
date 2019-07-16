
Feature('OpenMRS patient_registration_test');

Scenario('test something', (I) => {
    I.amOnPage('http://localhost:8090/openmrs');
    I.appendField('username', 'admin');
    I.appendField('password', 'Admin123');
    I.click('Outpatient Clinic');
    I.click('loginButton');
});



Feature('OpenMRS patient_registration_test');

Scenario('test something', (I) => {
    I.amOnPage('https://demo.openmrs.org/openmrs/login.htm');
    I.appendField('username', 'admin');
    I.appendField('password', 'Admin123');
    I.click('#Outpatient Clinic');
    I.click('#loginButton');

    I.click('#referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension')
    see('Register a patient')
    


});



Feature('OpenMRS patient_registration_test');

Scenario('test something', (I) => {
    I.amOnPage('https://demo.openmrs.org/openmrs/login.htm');
    I.appendField('username', 'admin');
    I.appendField('password', 'Admin123');
    I.click(`/html/body/div[@id='body-wrapper']/div[@id='content']/form[@id='login-form']/fieldset/ul[@id='sessionLocation']/li[@id='Outpatient Clinic']`);
    I.click('#loginButton');

    I.click('#referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension')
    I.see('Register a patient')
    
    // Name
    I.appendField('givenName', 'testGivenName3');
    I.appendField('middleName', 'testMiddleName3');
    I.appendField('familyName', 'testFamilyName3');

    // Gender
    I.click('#genderLabel');
    I.selectOption('#gender-field','M');

    // Birthday
    I.click('#birthdateLabel');
    I.appendField('birthdateDay', '19');
    I.selectOption('birthdateMonth','July');
    I.appendField('birthdateYear', '1990');

    // Address
    I.click(`/html/body/div[@id='body-wrapper']/div[@id='content']/div[@id='content']/form[@id='registration']/ul[@id='formBreadcrumb']/li[@class='doing'][2]/ul/li[@class='question-legend'][1]/span`)
    I.appendField('#address1', 'test address1');
    I.appendField('#address2', 'test address2');

    // Phone Number
    I.click(`/html/body/div[@id='body-wrapper']/div[@id='content']/div[@id='content']/form[@id='registration']/ul[@id='formBreadcrumb']/li[@class='doing'][2]/ul/li[@class='question-legend'][1]/span`);
    I.appendField('phoneNumber','0123456789');

    I.click('#confirmation_label');

    // Validate inputs
    I.see('Name: testGivenName3, testMiddleName3, testFamilyName3');
    I.see('Gender: Male');
    I.see('Birthdate: 19, July, 1990');
    I.see('Address: test address1, test address2');
    I.see('Phone Number: 0123456789');
    I.see('Relatives: --');

    I.click('#submit');

});


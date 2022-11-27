Feature: register.feature

  @CP_Add1 @All
  Scenario: Create a new user whit user exist
    Given Launch App
    When Register new user
      |Username      |ionixtester|
      |Password      |A123456a*|
      |Repeatpassword|A123456a*|
      |Email         |frulleddiziwa-3479@yopmail.com|
    Then Button Submit


  @CP_Add2 @All
  Scenario: Create a new user whit caracter @
    Given Launch App
    When Register new user
      | Username      | ionixtester@         |
      | Password      | A123456a*           |
      | Repeatpassword| A123456a*           |
      | Email         | frulleddiziwa-3479@yopmail.com|

  @CP_Add3 @All
  Scenario: Create a new user whit user in blank
    Given Launch App
    When Register new user
      | Username      |                     |
      | Password      | A123456a*           |
      | Repeatpassword| A123456a*           |
      | Email         | frulleddiziwa-3479@yopmail.com|
    Then Button Submit

  @CP_Add4 @All
  Scenario: Create a new user whit user valid
    Given Launch App
    When Register new user
      | Username      | CristianMaldonado   |
      | Password      | A123456a*           |
      | Repeatpassword| A123456a*           |
      | Email         | frulleddiziwa-3479@yopmail.com|
    Then Button Submit

  @CP_Add5 @All
  Scenario: Create a new user whit password six caracter
    Given Launch App
    When Register new user
      | Username      | CristianMaldonado|
      | Password      | A12345           |
      | Repeatpassword| A12345           |
      | Email         | frulleddiziwa-3479@yopmail.com|
    Then Button Submit


  @CP_Add6 @All
  Scenario: Create a new user whit password no capital letter
    Given Launch App
    When Register new user
      | Username      | CristianMaldonado  |
      | Password      | a123456*           |
      | Repeatpassword| a123456*           |
      | Email         | frulleddiziwa-3479@yopmail.com|
    Then Button Submit


  @CP_Add7 @All
  Scenario: Create a new user only capital letter
    Given Launch App
    When Register new user
      | Username      | CristianMaldonado  |
      | Password      | ABCABCAB           |
      | Repeatpassword| ABCABCAB           |
      | Email         | frulleddiziwa-3479@yopmail.com|
    Then Button Submit


  @CP_Add8 @All
  Scenario: Create a new user no special character in password
    Given Launch App
    When Register new user
      | Username      | CristianMaldonado  |
      | Password      | Aa123456           |
      | Repeatpassword| Aa123456           |
      | Email         | frulleddiziwa-3479@yopmail.com|
    Then Button Submit


  @CP_Add9 @All
  Scenario: Create a new user whit password OK
    Given Launch App
    When Register new user
      | Username      | CristianMaldonado   |
      | Password      | Aa12345*            |
      | Repeatpassword| Aa12345*            |
      | Email         | frulleddiziwa-3479@yopmail.com|
    Then Button Submit


  @CP_Add10 @All
  Scenario: Create a new user whit password in blank
    Given Launch App
    When Register new user
      | Username      | CristianMaldonado   |
      | Password      |                     |
      | Repeatpassword|                     |
      | Email         | frulleddiziwa-3479@yopmail.com|
    Then Button Submit


  @CP_Add11 @All
  Scenario: Create a new user whit password without numerical data
    Given Launch App
    When Register new user
      | Username      | CristianMaldonado   |
      | Password      | Aaaaaaaab*          |
      | Repeatpassword| Aaaaaaaab*          |
      | Email         | frulleddiziwa-3479@yopmail.com|
    Then Button Submit


  @CP_Add12 @All
  Scenario: Create a new user whit password different
    Given Launch App
    When Register new user
      | Username      | CristianMaldonado   |
      | Password      | A12345bb*            |
      | Repeatpassword| A54321cc/            |
      | Email         | frulleddiziwa-3479@yopmail.com|
    Then Button Submit


  @CP_Add13 @All
  Scenario: Create a new user whit second password in blank
    Given Launch App
    When Register new user
      | Username      | CristianMaldonado   |
      | Password      | A12345bb*           |
      | Repeatpassword|                     |
      | Email         | frulleddiziwa-3479@yopmail.com|
    Then Button Submit


  @CP_Add14 @All
  Scenario: Create a new user whit password Ok
    Given Launch App
    When Register new user
      | Username      | CristianMaldonado   |
      | Password      | A12345bb*            |
      | Repeatpassword| A12345bb*            |
      | Email         | frulleddiziwa-3479@yopmail.com|
    Then Button Submit


  @CP_Add15 @All
  Scenario: Create a new user whit email without @
    Given Launch App
    When Register new user
      | Username      | CristianMaldonado   |
      | Password      | A12345bb*           |
      | Repeatpassword| A12345bb*           |
      | Email         | frulleddiziwa-3479yopmail.com|
    Then Button Submit


  @CP_Add16 @All
  Scenario: Create a new user whit email OK
    Given Launch App
    When Register new user
      | Username      | CristianMaldonado   |
      | Password      | A12345bb*           |
      | Repeatpassword| A12345bb*           |
      | Email         | frulleddiziwa-3479@yopmail.com|
    Then Button Submit




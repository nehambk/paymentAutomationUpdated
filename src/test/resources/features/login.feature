
@Regression

  Feature: Login

    @Login
    Scenario Outline: As a user, I want to login
      Given API Url and Headers
      When I enter '<mobile_Number>'
      Then An OTP should be generated
      And Read OTP from database for '<mobile_Number>'

      Examples:
        | mobile_Number |
        | 7838983405    |
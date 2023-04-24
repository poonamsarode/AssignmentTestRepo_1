@ui  @HelthCheak
Feature:  E-commerce Project Web Site Health Check

@Search 
Scenario: User is able to opean the browser,navigate to the URL and Search for Product 
#Given    User opean the browser 
Given    User navigated to the home application url
And      Application title is "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store"
When     User search for a product "majestic solitaire diamond ring"
Then     Search result is displyed "majestic solitaire diamond ring"
 
 @SearchProd
 Scenario: User Search for product from search box 
#Given    User opened browser
Given    User navigated to the home application url
And      User search for a product "majestic solitaire diamond ring"
When     User Click on product "majestic solitaire diamond ring" 
Then     Product Description is displayed in new tab
 
@ProdDesc
Scenario: User is click on the Product and check the Product Details 
#Given    User opened browser
Given      User navigated to the home application url
And      User search for a product "mjestic solitaire diamond ring"
When     User Click on product "majestic solitaire diamond ring"
Then     Product Description is displayed in new tab
And      Select the size drop down
And      Notification is displyed "Price updated"
  
@FooterLinkLists 
Scenario: validate the footer links on landing page of applications  
   When  user scroll dwon to the button landing page of the application   
   And   the categories having the option "ABOUT US"
 	 Then  under the about us category below options are visible 
   | About Our Company     |
   | Terms and Conditions  | 
   | Privacy Policy        |
   | FAQ                   |
   | Offers T&Cs           |
   | Customer Reviews      |
  And   Browser is closed   
  
@SocialMediaIcons
Scenario Outline: validate the footer links on landing page of applications  
   When   user scroll dwon to the button landing page of the application  
   And    validate the follow us option with social media icons 
   When   click on social media icons "<Social media Name>"
   Then   Validating the social media Icons With Expected "<Expected>" and "<Pagetext>"
   Examples:
|     social media Icons      |     Expected      |          Pagetext              |
|     facebook                | canderejewellery  |   Candere by Kalyan Jewellers  |
|     instagram               | canderejewellery  |   canderejewellery             |
|     twitter                 | canderebyKalyan   |   Candere By Kalyan jewellers  |

  

     
     
     
     
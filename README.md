# Dealership-Application
Car dealership web application using SpringMVC

Car dealership web application using SpringMVC and Maven

In Eclipse, Run as Maven build, goals: "clean spring-boot:run".

This application allows visitors to browse and search vehicles for sale as guests (not logged in). It allows 
guests to register new accounts and login. Once logged in, purchase vehicles & bid for/purchase auction vehicles 
buttons are available. To login as a customer use email: thomas@email.com, password: pass.

To login as administrator use email: admin@dealer.com password: pass. The administrator has the ability to view 
listings, create new listings, view transaction history, and view a list of customers. Note: transaction history 
will be empty unless you first login as a customer and make a purchase.

The application has the following by default via static blocks using @PostConstruct: 1 administrator account 10 customer accounts 13 vehicles listed for sale

The dealership application has a bid fearture where if a vehicle has been in inventory for more than 120 days, 
it will be available for bidding/auction. Auction vehicles can be sold for up to a 10% discount from the original list price.

Once purchased (whether by regular purcahse or auction), listings are removed from the list of active vehicles for sale, 
and a transaction is recorded which links a customer with their purchased vehicle information. Transaction reports are available 
to the administrator after a logged-in customer has made a purchase.

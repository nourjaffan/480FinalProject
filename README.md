# 480FinalProject

IMPORTANT
To run this code, you will have to make your own database using the accountDatabase.sql file. Once you run that, make sure that there is a user in the MySQL database that is named 'test' and the password as "password". The database will be hosted by the localhost too. Once done, set it so the user has access to the database. If having problems follow this guide https://docs.rackspace.com/support/how-to/create-and-edit-users-in-mysql/. They use "newPassword" as the password but we changed it to "password". 

Once the database and user is set up, you can run the code with the jar file name Implementation.jar. To set up the movies, showtimes, and news, you will have go and login as an admin. To do that, type in 'admin' as the email and 'pass' as the password. If you would like to change those values, you will have to go inside the sql file and change where it says 'admin' and 'pass' to something you would like. Also you would need to change the code in loginGUI to equal those new values within the actionPerformed section. 

Once all those are set up, registered users will get a chance to get the reserved seats if the release date of a movie is beyond 3 days. Our theater has 40 seats so if 4 reserved seats get taken, registered users will not be able to choose that showtime anymore. Once those 3 days passes the guest users can start buying tickets. 

Once the seat is reserved, make sure the email is valid because it will send an email to the one used for registering or the one typed in as a guest user. All tickets will be entered into the database so make sure to keep the unique ticket number and your email safe. Cancellations will only occur when it is 3 days before the showtime. If the cancellation occurs, the ticket will be refunded as credit that expires 1 year after the date of testing. Since ticket prices are $15, registered users will be refunded $15 while guest users have to pay the 15% admin fee so they receive $12.75.

IMPORTANT
Once those 40 seats are taken or the showtime date goes past whatever date it is at the time of testing, the database will automatically remove the showtime. Always make sure the date added is the present date or in the future.

IMPORTANT
The same occurs when you make news. Make sure the date is the present date or in the future.

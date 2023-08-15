# BookMyFilm - Movie Ticket Booking Desktop Application

![bookmyfilm](https://github.com/mateen27/BookMyFilm/assets/136830885/ce8b655d-7917-441c-b227-fea5f663c495)

BookMyFilm is a comprehensive desktop application built using Java Swing and AWT technologies, featuring an intuitive interface that allows users to effortlessly book movie tickets for their favorite films. The application is backed by a MySQL database to ensure data integrity and efficient management of bookings. This README provides an overview of the project, its key features, setup instructions, and future plans.

## Key Features

1. **User Authentication**: Secure user registration and login system, with an additional layer of authorization through OTP verification using JavaMail API.

2. **Movie Selection**: Users can browse through a list of available movies, view showtimes, and select their preferred date and time for movie screenings.

3. **Seat Reservation**: Interactive seat selection interface that enables users to pick their desired seats for the chosen movie and showtime.

4. **Unique Booking System**: Once seats are selected, the application ensures that no other user can book the same seats for the same movie and showtime.

5. **Ticket Generation**: Upon successful booking, a unique ticket with a booking ID, movie name, date, time, and seat details is generated. The ticket offers options for immediate booking confirmation or paying at the cinema hall.

6. **Admin Panel**: An admin login enables administrators to manage movie details. The admin can add, update, or remove movies, including details such as movie name, time, date, banner, and prices.

## Installation and Setup

1. **Prerequisites**: Make sure you have Java, MySQL, and the required libraries (JavaMail, Java Activation, Timing Framework, MigLayout) installed.

2. **Database Setup**: Import the provided SQL script to set up the necessary database schema. Update the database credentials in the application code.

3. **Library Dependencies**: Include the necessary JAR files (JavaMail, Java Activation, Timing Framework, MigLayout) in your project build path.

4. **Running the Application**: Compile and run the `MainApp.java` file to launch the BookMyFilm application.

## Future Development

We have exciting plans for the future of BookMyFilm:

1. **Web Application**: We're actively developing a web version of BookMyFilm to provide users with a seamless movie booking experience on their browsers.

2. **Mobile App**: We're also working on a mobile app version for both Android and iOS platforms, allowing users to book movie tickets on the go.

3. **Enhanced User Profiles**: We'll be expanding user profiles to include booking history, favorite movies, and personalized recommendations.

4. **Advanced Admin Controls**: The admin panel will be equipped with advanced features, such as real-time occupancy tracking and advanced movie management options.

## Why BookMyFilm?

BookMyFilm was conceived to address the need for a user-friendly, efficient, and secure movie ticket booking platform. Our team recognized the potential of combining Java's Swing and AWT with MySQL to create a versatile desktop application. By integrating OTP verification, interactive seat selection, and a robust admin panel, we aimed to offer a holistic solution for both users and cinema administrators. As we continue to develop web and mobile versions, we strive to make movie ticket booking accessible and enjoyable for everyone.

## Get Involved

We welcome contributions, bug reports, and feature requests from the community. Feel free to fork this repository, create pull requests, or reach out to us with your suggestions.

---

**Disclaimer**: The BookMyFilm project is developed as a sample project for educational purposes. Any resemblance to real products or services is purely coincidental. The project's authors do not claim any rights to logos, images, or trademarks used in the application.
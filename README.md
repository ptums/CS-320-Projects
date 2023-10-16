# CS-320 Projects

In this repository, I have compiled a collection of files that showcase my work in software testing, automation, and quality assurance. This portfolio consists of submissions from two projects, each highlighting different aspects of my skills and expertise. Additionally, you will find reflections on my work, which provide valuable context for future reference.

## Project One

Files:
- `Appointment.java`-
- `AppointmentService.java`
- `AppointmentTest.java`
- `AppointmentServiceTest.java`
- `Contact.java`
- `ContactService.java`
- `ContactTest.java`
- `ContactServiceTest.java`
- `Task.java`
- `TaskService.java`
- `TaskTest.java`
- `TestServiceTest.java`

In Project One, I worked on ensuring every class achieved 100% coverage in terms of classes, methods, and lines. By trying to get 100% coverage, I exercised my ability to create unit tests that uncovered unforseen errors, analyze various approaches to software testing based on requirements, and apply appropriate testing strategies to meet those requirements.

## Project Two - Software Testing and Automation

### How can I ensure that my code, program, or software is functional and secure?

My approach aligned quite accurately with the software requirements for several reasons. The primary reason is that unit tests ensure basic functionality and durability by testing every method, guaranteeing consistent and correct output regardless of the function's input. Below, you can see the implementation of the testSetAppointmentDate method, which illustrates how the method consistently returns correct data, regardless of the input.

Every test suite covers 100% of the classes, methods, and lines. Each test suite consists of a minimum of two tests. Typically, these tests follow a common pattern: we assert that the output is not null, verify the correctness of the output for both primary and alternative inputs, and validate that the unique specifications result in the correct output. Below, you'll find the implementation of the testGetAppointmentId() method, which exemplifies this pattern.


### How do I interpret user needs and incorporate them into a program?

I employed a combination of black box and white box testing techniques for software testing. Each testing suite I designed started by ensuring that the function's output was not null and matched the intended output. Thus, I always initiated the testing process with the black box technique. Once I had thoroughly tested the fundamental aspects of the method, I introduced more advanced white box testing. White box testing, in essence, ensures the internal mechanisms of the method operate as intended.

Therefore, after verifying the correctness of the fundamental aspects through tests, I delved deeper into its inner mechanisms by creating tests that scrutinized the output in various scenarios. For instance, when testing `testGetAppointmentID()`, we needed to confirm that the ID length was under 10 characters. Consequently, we developed white box tests to assess `testGetAppointmentID()`, guaranteeing that the returned ID was always 10 characters or less. By utilizing a combination of white box and black box testing techniques, we ensured comprehensive coverage of the method. This approach not only validated that the method functioned as intended but also validated its performance under different scenarios.

### How do I approach designing software?

Initially, I would only create the basic test cases for the methods without further elaboration. However, as I progressed and wrote more code in subsequent assignments, my tests grew in both size and thoroughness. Consequently, my coverage score also improved. I realized that exporting the coverage details as an HTML file was a valuable practice. This HTML file revealed which lines of code were not covered by my tests and identified areas that required more comprehensive testing. Armed with these insights, I refined my tests to achieve 100% coverage across classes, methods, and individual lines. Through this experience, I learned that the key takeaway from the assignments, particularly Project One, is the necessity of continuous practice in writing tests. The more you engage in writing tests, the deeper your understanding of your code becomes, leading to more comprehensive and thorough tests.


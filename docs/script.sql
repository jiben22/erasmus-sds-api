/*==== INSERT ====*/

INSERT INTO profile (email, firstname, lastname, password) VALUES
('arthur.coat@student.put.poznan.pl', 'Arthur', 'COAT', '$2a$10$TCdrvG6zWUwrryQ.7Id6Qe9lJCWXaykTFH1vfRyrSRkmF5KK0DoCa');

INSERT INTO faculty (id, name, image_url) VALUES
('architecture', 'Architecture', 'faculty-architecture.webp'),
('automatic-control-robotics-electrical-engineering', 'Automatic Control, Robotics & Electrical Engineering', 'faculty-automatic-control-robotics-electrical-engineering.webp'),
('chemical-technology', 'Chemical Technology', 'faculty-chemical-technology.webp'),
('civil-transport-engineering', 'Civil and Transport Engineering', 'faculty-civil-transport-engineering.webp'),
('computing-telecommunications', 'Computing and Telecommunications', 'faculty-computing-telecommunications.webp'),
('engineering-management', 'Engineering Management', 'faculty-engineering-management.webp'),
('environmental-engineering-energy', 'Environmental Engineering and Energy', 'faculty-environmental-engineering-energy.webp'),
('materials-engineering-technical-physics', 'Materials Engineering and Technical Physics', 'faculty-materials-engineering-technical-physics.webp'),
('mechanical-engineering', 'Mechanical Engineering', 'faculty-mechanical-engineering.webp');

INSERT INTO course (id, title, description, ects, hours, semester, description_card_url, diploma, faculty_id) VALUES
('object-programming','Object Programming','The goal of the course is to teach students how to model and create reusable, easily-maintainable software, by using tools provided by object-oriented programming languages. Moreover, the students will learn how to create and use custom data types, how to model software systems based on clean code principles, and how to communicate their work to other programmers.',4,60,'Winter','Object-programming.pdf','Bsc','computing-telecommunications'),
('quality-management-experimental-software-engineering','Quality Management and Experimental Software Engineering','Provide students the knowledge regarding experimental Software Engineering, especially related to empirical research methods and their theoretical foundations.',5,125,'Winter','Quality-management-and-experimental-software-engineering.pdf','Master','computing-telecommunications'),
('software-architecture-and-verification','Software Architecture and Verification','Provide students with knowledge regarding software architecture, within the following scope of understanding what is software architecture, how it should be documented and evaluated.',6,145,'Winter','Software-architecture-and-verification.pdf','Master','computing-telecommunications'),
('software-development-studio-2','Software Development Studio 2','Provide to the students the foundations of project management and requirements engineering (and illustrate them with real-life cases) that are necessary to perform the management and analytical roles in software development projects.',6,150,'Winter','Software-development-studio-2.pdf','Master','computing-telecommunications'),
('operational-research','Operational Research','The course aims to introduce the students to the main topics in Operational Research (OR). These include linear programming, simplex algorithm, dual programming, sensitivity analysis, network optimization models, dynamic programming, integer programming, nonlinear programming, job scheduling, and heuristics. The students should get to know the basic methods, techniques, and algorithms for each of these sub-fields to use them for practical problem-solving.',5,60,'Winter','Operational-research.pdf','Bsc','computing-telecommunications'),
('internet-applications','Internet Applications','Gaining knowledge about www document and application development necessary to distinguish between basic internet application architectures and methods for implementing their modules. Enhancing knowledge about network architectures, protocols, and distributed systems security. Gaining skills in web application development using advanced user interface development technologies, such as CSS, JavaScript, presentation logic development, Single Page Application Frameworks, business logic development. Gaining social competences concerning working as a part of a team, including organising team work, in particular leadership and communication in the process of group problem solving.',5,60,'Winter','Internet-applications.pdf','Bsc','computing-telecommunications'),
('information-theory','Information Theory','The objective of the course is to present a selection of aspects of the Information Theory, one of the most fundamental theories underlying theoretical Computer Science of modern­day. The Information Theory deals with representing, storing and communicating information expressed in the form of symbols. Owing to the fact that many important applications of this theory reach far beyond the core of Computing Science, the presented selection of aspects will be confined to the most fundamental ones, mainly those related to such domains of the Computer Science as Data Exploration and Data Compression, in particular: Lossless Data Compression. The fruits of rapid development of notions in the Information Theory, initially disputable and professedly unsolvable, have soon turned out to be incredibly useful and to have a great deal of practical value. In the modern­day these solutions show up in virtually all imaginable computer systems in existence, ones that could hardly survive nowadays without the ubiquitous multimedia content, the popularity and versatility of which has been consistently and unwaveringly influenced by the accessibility of data compression methods.',3,30,'Winter','Internet-applications.pdf','Bsc','computing-telecommunications'),
('Career-resources','Career Resources','Provide students with basic knowledge regarding interpersonal communication in the workplace. Provide students with contemporary problems of interpersonal communication. Develop students'' skills in solving problems and communicating in groups. Advancing students'' language competence towards the level at least B2 (CEFR).',2,30,'Winter','Career-resources.pdf','Bsc','computing-telecommunications');
('information-theory','Information Theory','The objective of the course is to present a selection of aspects of the Information Theory, one of the most fundamental theories underlying theoretical Computer Science of modern­day. The Information Theory deals with representing, storing and communicating information expressed in the form of symbols. Owing to the fact that many important applications of this theory reach far beyond the core of Computing Science, the presented selection of aspects will be confined to the most fundamental ones, mainly those related to such domains of the Computer Science as Data Exploration and Data Compression, in particular: Lossless Data Compression. The fruits of rapid development of notions in the Information Theory, initially disputable and professedly unsolvable, have soon turned out to be incredibly useful and to have a great deal of practical value. In the modern­day these solutions show up in virtually all imaginable computer systems in existence, ones that could hardly survive nowadays without the ubiquitous multimedia content, the popularity and versatility of which has been consistently and unwaveringly influenced by the accessibility of data compression methods.',3,30,'Winter','Information-theory.pdf','Bsc','computing-telecommunications'),
('career-resources','Career Resources','Provide students with basic knowledge regarding interpersonal communication in the workplace. Provide students with contemporary problems of interpersonal communication. Develop students'' skills in solving problems and communicating in groups. Advancing students'' language competence towards the level at least B2 (CEFR).',2,30,'Winter','Career-resources.pdf','Bsc','computing-telecommunications');

INSERT INTO coordinator (name, last_name, email) VALUES
('Dariusz','Brzezinski','Dariusz.Brzezinski@cs.put.poznan.pl'),
('Sylwia','Kopczyńska','Sylwia.Kopczynska@cs.put.poznan.pl'),
('Mirosław','Ochodek','Miroslaw.Ochodek@cs.put.poznan.pl'),
('Bartosz','Walter','Bartosz.Walter@put.poznan.pl'),
('Michal','Mackowiak','Michal.Mackowiak@put.poznan.pl'),
('Michal','Tomczyk','Michal.Tomczyk@cs.put.poznan.pl'),
('Maciej','Piernik','Maciej.Piernik@cs.put.poznan.pl'),
('Robert','Susmaga','Robert.Susmaga@cs.put.poznan.pl'),
('Ewa','Hołubowicz','Ewa.Holubowicz@put.poznan.pl');

INSERT INTO course_coordinators (course_id, coordinators_email) VALUES
('object-programming','Dariusz.Brzezinski@cs.put.poznan.pl'),
('quality-management-experimental-software-engineering','Sylwia.Kopczynska@cs.put.poznan.pl'),
('quality-management-experimental-software-engineering','Miroslaw.Ochodek@cs.put.poznan.pl'),
('software-architecture-and-verification','Bartosz.Walter@put.poznan.pl'),
('software-architecture-and-verification','Michal.Mackowiak@put.poznan.pl'),
('software-development-studio-2','Sylwia.Kopczynska@cs.put.poznan.pl'),
('software-development-studio-2','Miroslaw.Ochodek@cs.put.poznan.pl'),
('operational-research','Michal.Tomczyk@cs.put.poznan.pl'),
('internet-applications','Maciej.Piernik@cs.put.poznan.pl'),
('information-theory','Robert.Susmaga@cs.put.poznan.pl'),
('career-resources','Ewa.Holubowicz@put.poznan.pl');

INSERT INTO erasmus_student (lastname, firstname, email, password) VALUES
('COAT', 'Arthur', 'arthur.coat@student.put.poznan.pl', '$2a$10$TCdrvG6zWUwrryQ.7Id6Qe9lJCWXaykTFH1vfRyrSRkmF5KK0DoCa');
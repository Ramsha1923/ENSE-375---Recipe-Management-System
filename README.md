#### ENSE 375 - Software Testing & Validation

<h2 align="center">Recipe Management System</h2>

### Team Members
- Ramsha Naeem  
- Kristina Langgard  
- Pratik Gadhiya  

## Table of Content
[1 Introduction](#1-Introduction)<br>
[2 Design Problem](#2-Design-Problem)<br>
&nbsp;&nbsp;&nbsp;[2.1 Problem Definition](###2.1-Problem-Definition)<br>
&nbsp;&nbsp;&nbsp;[2.2 Design Requirements](###2.2-Design-Requirements)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[2.2.1 Functions](####2.2.1-Functions)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[2.2.2 Objectives](####2.2.2-Objectives)<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[2.2.3 Constraints](####2.2.3-Constraints)<br>
&nbsp;&nbsp;&nbsp;[2.3 Components & Limitations](###2.3Components-&-Limitations)<br>
[3 Solution](#3-Solution)<br>
&nbsp;&nbsp;&nbsp;[3.1 Solution 1](###3.1-Solution-1)<br>
&nbsp;&nbsp;&nbsp;[3.2 Solution 2](###3.2-Solution-2)<br>
[4 Team-Work](#4-Team-Work)<br>
&nbsp;&nbsp;&nbsp;[4.1 Meeting 1](###4.1-Meeting-1)<br>
&nbsp;&nbsp;&nbsp;[4.2 Meeting 2](###4.2-Meeting-2)<br>
&nbsp;&nbsp;&nbsp;[4.3 Meeting 3](###4.3-Meeting-3)<br>
&nbsp;&nbsp;&nbsp;[4.4 Meeting 4](###4.4-Meeting-4)<br>

## 1. Introduction
This project focuses on designing and developing a Recipe Management System, a Java-based desktop application that allows users to create, manage, and search their personal recipes.  
We aim to simplify the process of storing and accessing culinary information with mindfulness of a user-friendly experience. In traditional alternatives, there is a lack of organization and limited accessible tools for individuals who enjoy cooking and want to manage their recipes. Existing solutions are often either overly complicated or too limited in functionality. We wish to modernize the experience to be convenient and approachable.

## 2. Design Problem
### 2.1	Problem Definition
#### Challenges with Current Recipe Organization Methods:
**1.	Lack of Centralized Storage:**
There are no established ways to consolidate handwritten recipes, printed cookbooks and bookmarked websites for easy viewing and retrieval.<br>
**2.	Complexity of Existing Platforms:**
Popular recipe organizing programs often provide more features than are necessary for simple users, leading to increased complexity and difficulty.<br>
**3.	Limited Customization Options:**
Existing platforms often don’t allow users to fully control their data or customize their recipe entries, such as adding personalized tags or categorizing based on meal type.
#### Advantages of Implementing a Digital Recipe Management Tool:
**1.	Streamlined Organization:**
A dedicated desktop application allows recipes to be categorized, tagged, and searched quickly, enabling easy access to meal ideas.<br>
**2.	Intuitive User Experience:**
A simplified interface focused solely on recipe management avoids clutter and enhances usability for users of all skill levels.<br>
**3.	Offline Functionality:**
Unlike web-based platforms, this application will function fully offline, ensuring availability in all environments, including kitchens with limited connectivity.<br>
#### Rationale:
The need for this project became clear after observing the difficulties faced by home cooks and hobbyists in managing recipes effectively. Paper-based systems are prone to damage and disorganization, while online platforms often come with distractions or require internet access. Our proposed Recipe Management System addresses these issues by offering a simple, efficient, and accessible way to store and retrieve recipes, without unnecessary complications.

### 2.2	Design Requirements
From our vision and outlined design problem, we are putting an emphasis on the database interactivity and readability of our program, focusing on its core functions and how users will interact with them. 

#### 2.2.1	Functions
&nbsp;&nbsp;&nbsp;**1.  Create/store a recipe:** <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;a.  Ability to create or upload a recipe in-app.<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;b.  Ability to save the recipe for later use.<br>
&nbsp;&nbsp;&nbsp;**2.  Viewing a recipe:** <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;a.  Ability to retrieve a saved recipe when needed.<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;b.  Ability to retrieve said recipe on different devices, such as a desktop computer, phone, or tablet. <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;c.  Ability to view recipes while offline.<br> 
&nbsp;&nbsp;&nbsp;**3.  Organizing recipes:** <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;a.  Ability to apply custom tags/filters to recipes. <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;b.  Ability to sort by custom tags. <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;c.  Ability to search from saved recipes. <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;d.  Ability to favourite recipes. <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;e.  Ability to remove recipes that are no longer needed. <br>
&nbsp;&nbsp;&nbsp;**4.  Sharing recipes:** <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;a.  Ability to back-up a collection of recipes. <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;b.  Ability to share a collection of recipes with another user. <br>

#### 2.2.2	Objectives <br>
To accomplish our goals with this application, we have the following objectives in place: <br>
&nbsp;&nbsp;&nbsp;**1.  User-friendly:** the system should offer a clean and intuitive interface.<br>
&nbsp;&nbsp;&nbsp;**2.  Efficient:** the system should respond quickly and minimize unnecessary steps. <br>
&nbsp;&nbsp;&nbsp;**3.  Reliable:** the system should handle data accurately and predictably.<br>
&nbsp;&nbsp;&nbsp;**4.  Maintainable:** the system should follow clean design principles with modular components to support future development.<br>
&nbsp;&nbsp;&nbsp;**5.  Secure:** the system should validate user input to prevent invalid or malicious entries and ensure data integrity. <br>

#### 2.2.3	Constraints <br>

**Offline capability:** <br>
- An online database is not necessary to store and retrieve data, but rather a local storage system that mimics the concepts for retrieval and management in large collections. <br>
- Sharing recipes and backing up a collection of recipes must be done in a way that can be done through file sharing, such as use of a JSON file to store and read information between independent instances of the application. This must include an import/export feature to handle these files for users so they may accomplish this seamlessly. <br>
**Security:** <br>
- No information needs to be passed online, and removes the need for account verifications.  <br>
- File and input verification are important to the integrity and function of the application in all aspects, so we must ensure all inputs to the application are appropriate and malicious behaviour is avoided. This should be achieved by preventing the use of restricted characters and file types.  <br>
**File types and inputs:** <br>
- Files may not necessarily be text-based, and may also include images. <br>
- Tags and filters can and should be able to be used based on text criteria, but must also be applied should the media a user intends to use includes images. <br>
**Tags and filters:** <br>
- They may not be based on text-skimming technology due to the variance in accepted file types. <br>
- User may edit or change them independently. <br>
- Favoriting recipes as a unique tag and sort option. <br>
**Removing recipes and data that are no longer wanted:**  <br>
- Properly disposing of related data to remove unnecessary bloat and preserve privacy. <br>
**Economically:**  <br>
- We do not wish to use any external services or paid APIs to accomplish the functions of our application. <br>
- It is made to be free and open-source, to the benefit of our users. <br>
**Ethically:** <br>
- No user account or personal data should be collected, as part of the mindfulness of privacy and security, and all user inputs or outputs shall be handled equally without bias. <br>

### 2.3	Components & Limitations

##  System Components
- **User Interface**: JavaFX-based GUI
- **Data Model**: Recipe structure with title, ingredients, instructions, tags, image
- **Storage**: Local JSON file system for persistence
- **Search Engine**: Title/tag/ingredient-based lookup
- **Image Handler**: Support for local images
- **Import/Export**: JSON-based data sharing

##  Limitations
- No cloud sync or user authentication
- Sharing is manual via exported files
- No smart tagging or AI categorization
- Desktop-only application
- No accessibility features (e.g. screen readers)

## 3. Solution  <br>
### 3.1	Solution 1  <br>
### 3.2	Solution 2  <br>

## 4. Team Work  <br>
Weekly meeting records
### 4.1  Meeting 1
Time: May 14, 2025: 2pm to 5pm  \
Agenda: Problem Definition Discussion
|           Team Member          | Previous Task | Completion State |         Next Task         |
|:------------------------------:|:-------------:|:----------------:|:-------------------------:|
|         Ramsha Naeem           |      N/A      |        N/A       | Detailed Problem Analysis |
|       Kristina Langgard        |      N/A      |        N/A       | Detailed Problem Analysis |
|         Pratik Gadhiya         |      N/A      |        N/A       | Detailed Problem Analysis |

### 4.2  Meeting 2
Time: May 19, 2025: 5pm to 9pm  \
Agenda: Design Constraints and Requirements Discussion
|           Team Member          |         Previous Task         | Completion State |                 Next Task                 |
|:------------------------------:|:-----------------------------:|:----------------:|:-----------------------------------------:|
|         Ramsha Naeem           |    Detailed Problem Analysis  |       100%       | Define Limitations and Gather Requirement |
|       Kristina Langgard        |    Detailed Problem Analysis  |       100%       |    Define Limitations and Gather Needs    |
|         Pratik Gadhiya         |    Detailed Problem Analysis  |       100%       |            Specify Constraint             |

### 4.3  Meeting 3
Time: May 23, 2025: 5pm to 9pm  \
Agenda: Solution Discussion and Delegation of Tasks for Solution 1
|           Team Member          |               Previous Task                 | Completion State |                         Next Task                        |
|:------------------------------:|:-------------------------------------------:|:----------------:|:--------------------------------------------------------:|
|         Ramsha Naeem           |   Define Limitations and Gather Requirement |       100%       |   Develop Ideas and Code Implementation for Solution 1   |
|       Kristina Langgard        |      Define Limitations and Gather Needs    |       100%       |   Develop Ideas and Code Implementation for Solution 1   |
|         Pratik Gadhiya         |              Specify Constraint             |       100%       |               Identify Possible Approaches               |

### 4.4  Meeting 4
Time: May 28, 2025: 2pm to 5pm  \
Agenda: Solution 1 Progress Check and Solution 2 Task Distribution
|           Team Member          |                     Previous Task                        | Completion State |                            Next Task                           |
|:------------------------------:|:--------------------------------------------------------:|:----------------:|:--------------------------------------------------------------:|
|         Ramsha Naeem           |   Develop Ideas and Code Implementation for Solution 1   |       100%       |    Examine Solution 1 Outcomes and Write Code for Solution 2   |
|       Kristina Langgard        |   Develop Ideas and Code Implementation for Solution 1   |       100%       |    Examine Solution 1 Outcomes and Write Code for Solution 2   |
|         Pratik Gadhiya         |               Identify Possible Approaches               |       100%       |       Review Solution 1 and Perform Markdown Syntax Check      |

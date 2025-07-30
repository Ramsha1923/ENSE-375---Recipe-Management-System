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
&nbsp;&nbsp;&nbsp;[3.3 Final Solution](###3.3-Final-Solution)<br>

[4 Team-Work](#4-Team-Work)<br>
&nbsp;&nbsp;&nbsp;[4.1 Meeting 1](###4.1-Meeting-1)<br>
&nbsp;&nbsp;&nbsp;[4.2 Meeting 2](###4.2-Meeting-2)<br>
&nbsp;&nbsp;&nbsp;[4.3 Meeting 3](###4.3-Meeting-3)<br>
&nbsp;&nbsp;&nbsp;[4.4 Meeting 4](###4.4-Meeting-4)<br>
&nbsp;&nbsp;&nbsp;[4.5 Meeting 5](###4.5-Meeting-5)<br>
&nbsp;&nbsp;&nbsp;[4.6 Meeting 6](###4.6-Meeting-6)<br>
&nbsp;&nbsp;&nbsp;[4.7 Meeting 7](###4.7-Meeting-7)<br>
&nbsp;&nbsp;&nbsp;[4.8 Meeting 8](###4.8-Meeting-8)<br>
&nbsp;&nbsp;&nbsp;[4.9 Meeting 9](###4.9-Meeting-9)<br>
&nbsp;&nbsp;&nbsp;[4.10 Meeting 10](###4.10-Meeting-10)<br>
&nbsp;&nbsp;&nbsp;[4.11 Meeting 11](###4.11-Meeting-11)<br>

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
**Overview** <br>
Solution 1 proposes building a basic Java desktop application for recipe management, where each recipe is stored as a separate plain text file (.txt) on the user's local computer. The application provides a minimal graphical user interface (GUI) for users to create, view, and delete recipes. All recipes are saved in a single folder, with each recipe occupying its own file. 

**How It Works**  <br>
**Recipe Creation**  <br>
- The user clicks an “Add Recipe” button in the application.
- A form appears, allowing the user to enter the recipe title, ingredients, and instructions.
- When the user clicks “Save,” the application concatenates all the entered information into a single string and writes it to a new .txt file.
- The file is typically named after the recipe title (e.g., ChocolateCake.txt). If a file with the same name exists, a timestamp or number may be appended to avoid overwriting.

**Recipe Viewing**
- The application scans the designated recipes folder for all .txt files.
- It displays a list of these files (usually by filename) to the user.
- When a user selects a recipe, the application reads the contents of the corresponding .txt file and displays it in a simple, scrollable text area.

**Recipe Deletion**
- The user selects a recipe from the list and clicks a “Delete” button.
- The application deletes the corresponding .txt file from the folder.

**User Interface**
- The GUI is typically composed of:
- A list or table showing all recipe files.
- Buttons for “Add Recipe,” “View Recipe,” and “Delete Recipe.”
- A text area for displaying or editing recipe contents.

**Features and Limitations**
**Supported Features**
- **Basic CRUD**: Create, Read, and Delete recipes.
- **Offline Access**: All data is local; no internet required.
- **Simplicity**: Easy to implement and understand.

**Limitations**
- **No Structure:** The data is just plain text, so there is no enforced format for ingredients, steps, or other fields.
- **No Organization:** No support for tags, categories, favorites, or sorting other than by filename.
- **No Media Support:** Cannot attach images or multimedia to recipes.
- **No Search or Filter:** Users cannot search for recipes by ingredient, tag, or keyword.
- **No Import/Export:** Recipes cannot be easily shared or backed up except by copying files manually.
- **No Validation:** There is no way to ensure users enter all necessary information or use a consistent format.
  
**Testing and Validation Issues**
- **Difficult to Test Data Integrity:** Since the file format is not enforced, automated tests cannot reliably check for missing or malformed fields.
- **Limited Test Automation:** Automated tests can only verify file creation, reading, and deletion—not the correctness of recipe content.
- **No Advanced Features to Test:** Search, filter, tagging, and image attachment cannot be tested because they do not exist.
- **No Input Validation:** The application cannot prevent invalid or incomplete recipes from being saved, making boundary value and equivalence class testing meaningless.
  
**Why This Solution Is Not Selected**
- **Poor Testability:** Most software testing techniques (e.g., boundary value, equivalence class, state transition, decision tables) cannot be applied to unstructured text files.
- **Lack of Features:** Does not meet the project requirements for organization, searchability, or extensibility.
- **Not Scalable:** As the number of recipes grows, managing them becomes cumbersome and error-prone.
- **Difficult Maintenance:** Any future improvements (like adding tags or images) would require a complete redesign.
  
**In summary:** Solution 1a is a simple and easy-to-implement approach that works for the most basic use case of storing and viewing recipes. However, it lacks structure, organization, and extensibility, making it unsuitable for a robust, testable, and maintainable recipe management system.

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

### 4.5  Meeting 5
Time: May 28, 2025: 2pm to 5pm  \
Agenda: Review Progress on Solution 2
|           Team Member          |                        Previous Task                           | Completion State |               Next Task              |
|:------------------------------:|:--------------------------------------------------------------:|:----------------:|:------------------------------------:|
|         Ramsha Naeem           |   Examine Solution 1 Outcomes and Write Code for Solution 2    |       80%        |          Finalize Solution 2         |
|       Kristina Langgard        |   Examine Solution 1 Outcomes and Write Code for Solution 2    |       75%        |          Finalize Solution 2         |
|         Pratik Gadhiya         |    Review Solution 1 and Perform Markdown Syntax Check         |       75%        |   Complete REPORT.md up to Week 7    |

### 4.6  Meeting 6
Time: June 1, 2025: 2pm to 5pm  \
Agenda: Discuss Final Solution Planning
|           Team Member          |              Previous Task              | Completion State |                     Next Task                  |
|:------------------------------:|:---------------------------------------:|:----------------:|:----------------------------------------------:|
|         Ramsha Naeem           |           Finalize Solution 2           |       100%       |     Brainstorm features for final solution     |
|       Kristina Langgard        |           Finalize Solution 2           |       100%       |       Plan testing for final solution          |
|         Pratik Gadhiya         |     Complete REPORT.md up to Week 7     |       100%       |     Brainstorm features for final solution     |

### 4.7  Meeting 7
Time: June 14, 2025: 5pm to 8pm  \
Agenda: Assign Final Solution Tasks
|           Team Member          |                  Previous Task                    | Completion State |                    Next Task                  |
|:------------------------------:|:-------------------------------------------------:|:----------------:|:---------------------------------------------:|
|         Ramsha Naeem           |      Brainstorm features for final solution       |       100%       |     Implement and test the final solution     |
|       Kristina Langgard        |          Plan testing for final solution          |       100%       |      Develop code for the final solution      |
|         Pratik Gadhiya         |      Brainstorm features for final solution       |       100%       |     Provide feedback on the final solution    |

### 4.8  Meeting 8
Time: June 15, 2025: 2pm to 6pm  \
Agenda: Review Final Solution Progress
|           Team Member          |                     Previous Task                        | Completion State |                               Next Task                            |
|:------------------------------:|:--------------------------------------------------------:|:----------------:|:------------------------------------------------------------------:|
|         Ramsha Naeem           |          Implement and test the final solution           |       50%        |     Continue coding and testing the solution with Documentation    |
|       Kristina Langgard        |           Develop code for the final solution            |       50%        |               Continue developing the final solution               |
|         Pratik Gadhiya         |          Provide feedback on the final solution          |       60%        |                         Continue feedback                          |

### 4.9  Meeting 9
Time: June 12, 2025: 4pm to 9pm  \
Agenda: Final Progress Review
|           Team Member          |                          Previous Task                            | Completion State |                      Next Task                      |
|:------------------------------:|:-----------------------------------------------------------------:|:----------------:|:---------------------------------------------------:|
|         Ramsha Naeem           |   Continue coding and testing the solution with 	Documentation    |       80%        |      Finalize coding, testing, and documentation    |
|       Kristina Langgard        |              Continue developing the final solution               |       80%        |               Finalize developement                 | 
|         Pratik Gadhiya         |                        Continue feedback                          |       70%        |                  complete report                    |

### 4.10  Meeting 10
Time: July 25, 2025: 2pm to 5pm  \
Agenda: Presentation Task Assignment
|           Team Member          |                Previous Task                   | Completion State |                    Next Task                  |
|:------------------------------:|:----------------------------------------------:|:----------------:|:---------------------------------------------:|
|         Ramsha Naeem           |  Finalize coding, testing, and documentation   |       100%       |    Prepare slides and rehearse presentation   |
|       Kristina Langgard        |             Finalize developement              |       100%       |           Prepare for presentation            |
|         Pratik Gadhiya         |               complete report                  |       100%       |              Finalize REPORT                  |

### 4.11  Meeting 11
Time: July 28, 2025: 2pm to 5pm  \
Agenda: Presentation Recording
|           Team Member          |              Previous Task                  | Completion State |                            Next Task                           |
|:------------------------------:|:-------------------------------------------:|:----------------:|:--------------------------------------------------------------:|
|         Ramsha Naeem           |   Prepare slides and rehearse presentation  |       100%       |         	 Complete recording and all documentation            |
|       Kristina Langgard        |          Prepare for presentation           |       100%       |                     Complete the recording                     |
|         Pratik Gadhiya         |              Finalize REPORT                |       100%       |                     Complete the recording                     |

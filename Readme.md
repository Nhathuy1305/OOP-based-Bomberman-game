
<div id="top" align="center">
<img src="screenshots/Banner_For_Readme.png" alt="Banner">
</div>

[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]


<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/Nhathuy1305/OOP_BOMBERMAN_GAME.git">
    <img src="res/images/ttsalpha4.0@0.5x.png" alt="Logo" width="200" height="200">
  </a>

  <h3 align="center">OOP BOMBERMAN PROJECT</h3>
  <h4 align="center">Team Name: 404 NOT FOUND</h4>	

  <p align="center">
    A Java game created with JavaFX for OOP course in International University - VNUHCM!
    <br />
    <br />
    <a href="https://youtu.be/iLo5E-07aY0">View Demo</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#introduction">Introduction</a>
      <ul>
        <li><a href="#team-members">Team Members</a></li>
	<li><a href="#installation">Installation</a></li>
	<li><a href="#motivation">Motivation</a></li>
	<li><a href="#task-allocation">Task Allocation</a></li>      
      </ul>
    </li>
    <li><a href="#technologies">Technologies</a></li>
    <li><a href="#uml-class-diagram">UML Class Diagram</a></li>
    <li><a href="#features">Features</a></li>
    <li><a href="#challenges">Challenges</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#references">References</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## Introduction

<div align="center">
<img src="https://im3.ezgif.com/tmp/ezgif-3-3359dd0762.gif" alt="">
</div>


<div style="text-align:justify">
This is our game project for our final lab in our Object-Oriented Programming course in semester 2 (2020 - 2021). Bomberman is an individual game that does not require players have excellent skills or advanced technology. It's a straightforward game that may be enjoyed by people of all ages. As a result of all of these factors, we developed a program that is user-friendly and assists users in having the greatest possible experiences. So, what are we waiting for? Let the story begin!
</div>

### Team Members

|Order    | Name      | ID  |              Email               | Github account       |    Facebook            | 
| :------------: |   :---:       | :--------: |:--------------------------------:|:---------------------------:| :----------------:|
|1| Pham Gia Bao           | ITITIU20166  |  Phamgiabao1862001@gmail.com     |   [giabao18](https://github.com/giabao18)                      |  [Gia Bảo](https://www.facebook.com/profile.php?id=100007374601572) |
|2| Phan Nguyen Hoang Bao  | ITITIU20165  | hoangbao15082002@gmail.com       | [Mr@JEY](https://github.com/PhanNguyenHoangBao-ITITIU20165)                           |  [Hoàng Bảo](https://www.facebook.com/kuma.jeyruei)|
|3| Nguyen Luan Cong Bang  | ITITIU20163  | bangnguyen.071102@gmail.com      |   [congbangitiu](https://github.com/congbangitiu)                  | [Công Bằng](https://www.facebook.com/congbang.nguyenluan)|
|4| Dang Nhat Huy          | ITITIU20043  | dnhuy.ityu@gmail.com             |    [Nhathuy1305](https://github.com/Nhathuy1305)                        | [Nhật Huy](https://www.facebook.com/nhhuy.135/)|

### Installation

1. Open the terminal on your IDE
2. Clone the repo
   ```sh
   git clone https://github.com/Nhathuy1305/OOP_BOMBERMAN_GAME
   ```
3. Check the file status
   ```sh
   git status
   ```
4. Change branch 
   ```js
   git checkout 'branch_name'
   ```

### Motivation

<div style="text-align:justify">
As a fresher developer, we assume that the Bomberman game is one the most simple game which helps us in practicing coding with OOP also some significant aspects of the front-end such as: How to render the game? , How frame working in UX/UI? , ….
</div>

### Task Allocation

|Order| Task      | Person |Contribution|
|:---|   :-------------------------------------------------------| :--------: |:-----:|
| 1  | Level, Utility, Readme     | Gia Bao      |25|
| 2  | Control, Ui| Hoang Bao    |25|
|3| Entities, PowerPoint | Cong Bang|   25  |
|4| Graphics, PowerPoint, Github Management | Nhat Huy |  25  |  

<br />
## GAME <a name="Game"></a> :rocket:
## Requirement for software:  

## Technologies
- Language:  [JAVA](https://www.java.com/en/)
- Framework:  [IntelliJ](https://www.jetbrains.com/idea/), [Visual Studio Code](https://code.visualstudio.com)
- Intelligent:  [A* algorithms](https://www.geeksforgeeks.org/a-search-algorithm/)
- Library:  [JavaFx](https://openjfx.io)

### How to play:question:
<div style="text-align:justify">
Players will direct the character's movement in order to place bombs to killing the enemy. After the player has killed all of the monsters of this level a portal will open for the character to enter in order to advance to the next level (we have 3 levels).
</div>

### Game logic :bulb:
#### Character
<div style="text-align:justify">
 The character is controlled by the arrow key combination, only one bomb can be placed at a time.Moreover ,The character will gain speed change if the value is SpeedItem.
<div align="center">
<img src="https://im3.ezgif.com/tmp/ezgif-3-d651f37bfc.gif" alt="">
</div>
</div>

<br />

#### Bomb
<div style="text-align:justify">
 When the bomb explodes, it will create a fire trail, if the character or the enemy hits the fire trail, they will all be destroyed. The length of the flame will increase if the character eats flame item.
<div align="center">
<img src="https://im3.ezgif.com/tmp/ezgif-3-d611e523e4.gif" alt="">
</div>
</div>

<br />

#### Enemy
<div style="text-align:justify">
Includes 4 types and is divided by level, each type has its own attribute.
<div align="center">
<img src="https://im3.ezgif.com/tmp/ezgif-3-23039a9fe0.gif" alt="">
<img src="https://im2.ezgif.com/tmp/ezgif-2-20ed5fdbe9.gif" alt="">
<img src="https://im2.ezgif.com/tmp/ezgif-2-217f6043c8.gif" alt="">
<img src="https://im2.ezgif.com/tmp/ezgif-2-fb0436521c.gif" alt="">
</div>
</div>

<br />

#### Brick
<div style="text-align:justify">
It Can be broken by bombs and can contain items
</div>

<br />

#### Wall
<div style="text-align:justify">
It cannot be broken to limit the movement of characters and enemies
</div>


<br />

## UML Class Diagram

<br />

## Features

<br />

<!-- CHALLENGES -->
## Challenges
- Task allocation for each team member
- Using platform for communication ([Trello](https://trello.com/b/Ac0ISkzt/bomber-game-oop-project-2022))  
- Working environment (Github)

<br />
	
## Acknowledgments

<br />



<br />

## References



<p align="right">(<a href="#top">Back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/Nhathuy1305/OOP_BOMBERMAN_GAME.svg?style=for-the-badge
[contributors-url]: https://github.com/Nhathuy1305/OOP_BOMBERMAN_GAME/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/Nhathuy1305/OOP_BOMBERMAN_GAME.svg?style=for-the-badge
[forks-url]: https://github.com/Nhathuy1305/OOP_BOMBERMAN_GAME/network/members
[stars-shield]: https://img.shields.io/github/stars/Nhathuy1305/OOP_BOMBERMAN_GAME.svg?style=for-the-badge
[stars-url]: https://github.com/Nhathuy1305/OOP_BOMBERMAN_GAME/stargazers
[issues-shield]: https://img.shields.io/github/issues/Nhathuy1305/OOP_BOMBERMAN_GAME.svg?style=for-the-badge
[issues-url]: https://github.com//Nhathuy1305/OOP_BOMBERMAN_GAME/issues

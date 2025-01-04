# SwapStyles

<p align="center">
	  <img src="https://github.com/Ruben-BV/swap_styles_social_network/blob/dev/src/main/resources/images/Logo/Logo_Swap_Styles.jpeg" width="25%"/>
</p>

## Description
This project is about the development of a Rest API that allows users to add, edit and delete clothes and shoes from their closet. Each garment can have attributes such as name, category (shirt, pants, etc.), description...
<br><br>Each of these garments can be defined as visible or not visible, so that they are available or not available to be borrowed.
<br><br>By contacting friends through the application, it will be possible to see the garments that these friends are willing to share with the user.

## UML Class Diagramm
<p align="center">
	  <img src="https://github.com/Ruben-BV/swap_styles_social_network/blob/dev/src/main/resources/images/UML_Class_Diagramm.jpg?raw=true" />
</p>

## ER Diagramm
<p align="center">
	  <img src="https://github.com/Ruben-BV/swap_styles_social_network/blob/dev/src/main/resources/images/ER_Diagramm.jpg?raw=true" />
</p>

## Tech Stack implemented

<p align="center">
	  <img src="https://github.com/Ruben-BV/swap_styles_social_network/blob/dev/src/main/resources/images/Tech_Stack_01.jpg?raw=true" width="75%"/>
</p>

<p align="center">
	  <img src="https://github.com/Ruben-BV/swap_styles_social_network/blob/dev/src/main/resources/images/Tech_Stack_02.jpg?raw=true" width="50%"/>
</p>

## Start the aplication
- In the terminal of your code editor, write:
```bash
mvn spring-boot:run
```

## Connect to the Database (H2)
- In your webbrowser:
```bash
http://localhost:8080/h2-console
```
<p align="center">
	  <img src="https://github.com/Ruben-BV/swap_styles_social_network/blob/dev/src/main/resources/images/H2_01.jpg" />
</p>

- Click the butto "Connect"
<p align="center">
	  <img src="https://github.com/Ruben-BV/swap_styles_social_network/blob/dev/src/main/resources/images/H2_02.jpg" />
</p>

## Endpoints
You can find all the endpoint in the files:
- UserController.java
- FriendshipController.java
- Wardrobe.java
- ClothingItemController.java

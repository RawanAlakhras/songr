# songr

Web application that can handle albums and song to view them and add new albums and songs to specific albums .

# installation

1. open your terminal

2. clone my repo by command

    > git clone git@github.com:RawanAlakhras/songr.git

3. cd into it .

4. Run this command to start the server

    > pg_ctl -D /home/linuxbrew/.linuxbrew/var/postgres start

5. Validate that postgres clients can connect
    > psql

6. Create your "user" database

    > CREATE DATABASE databaseName
    > \c databaseName

7. go to songr/src/main/resources/application.properties then :

    * change **spring.datasource.username** to your user name.
    * change **spring.datasource.password** to your password .
    * change spring.datasource.url=jdbc:postgresql://localhost:5432/**databaseName**

8. run the application by IDE then go to your browser and write <http://localhost:8080/>.
9. now you are in the home page from navbar click on album link .
10. now you are in the album page but it is empty .
11. to add some albums in database and render it in album page you need to :
    * go to ><http://localhost:8080/addAlbum>
    * it will redirect you to albums page and three album has been add .
    * it is a initial data .
12. you can insert new album by click on add album red button then the form will be shown:
    * write the title of your album
    * write the name of artist
    * write the song Count
    * write the length
    * write the image url for your album .
    * then press submit
13. now your new album has been add to your database and it render in album page enjoy .

* every album's card display a list of songe they have.

# Songs 

* from navbar you can go to songs linke
* then all song should be display 
* from add song button you can press to it then form will be shown 
* write all information about your song you want to add then press submit 
* the new song should be display .


# Usage


* <http://localhost:8080/hello>
  * show hello world msg
* <http://localhost:8080/capitalize/hello>
  * route that turns words into UPPER CASE
  * you can change hello to any word you want
* <http://localhost:8080/>
  * render the home page of project
* <http://localhost:8080/albums>
  * shows three album instances
* <http://localhost:8080/addAlbum>
  * to add three album to database and render it in addition to one song related to first album .
* you can go to album from navbar then click to add new album to add new album and store it in database

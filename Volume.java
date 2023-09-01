/**
 * A program that finds the area of a circle and the corosponding cylinder's surface area and volume
 * with a set height.
 * @author     Quesenberry, Travis
 * @assignment ICS 212 Assignment 21
 * @date       12/06/2022
 */


#include <stdio.h>
#include <stdlib.h>
#include <iostream>
using namespace std;
#define pi 3.1415926


 class Circle{

  protected:
   double radius;

  public:

//default constructor.
   Circle(){
   radius = 1;
   }

//overload constructor
  Circle(double rad){
   setRadius(rad);
 }
//accessor function for radius
  double getRadius(){
   return radius;
  }

//mutator method for radius 
  void setRadius(double rad){ 
   if(rad < 0){
    radius = rad * -1;
   }else if(rad == 0){
     radius = 1;
   }else{
    radius = rad;
   }
  }             

//calculate the area of the circle with current radius 
   double area(){
   return radius * radius * pi;
  }
 
 };

//cylinder derive class
 class Cylinder : public Circle{
  
  private:
   double height;

  public:
  
//default constructor
  Cylinder(double rad, double heightparam){
   setRadius(rad); 
   setHeight(heightparam);
 }


//accessor function for cylinder height
 double getHeight(){
   return height;
 }

//mutator method for height
 void setHeight(double heightparam){
  if(heightparam < 0){
   height = heightparam * -1;
  }else if(heightparam == 0){
   height = 1;
  }else{
   height = heightparam;
  }
 }
  
//Calculate surface area of cylinder
 double area(){
  return 2*(pi*radius*height) + 2*(radius * radius * pi);
 }

//calculate volune of cyilinder
 double volume(){
  return pi*(radius*radius)*height;
 }

 };

int main(){

  // Test the default constructor.
  // The radius should be 1.
  cout << "Test Circle class default constructor and area() function:" << endl;
  Circle circle1;
  
  // With radius 1, the expected output is:
  // Circle circle1: radius = 1
  // area = 3.14159
  cout << "Circle circle1: radius = " << circle1.getRadius() << endl;
  cout << "area = " << circle1.area() << endl;
  
  cout << "\n";

 // Test the overloaded constructor that makes a circle given a radius.
  // Attempt to create a circle with an invalid, negative radius.
  // The constructor should make it positive instead -10 --> 10
  cout << "Test Circle class constructor with radius (-10):" << endl;
  Circle circle2(-10);
  
  // With the radius changed to positive 10, the expected output is:
  // Test Circle class constructor with radius:
  // Circle circle2: radius = 10
  cout << "Circle circle2: radius = " << circle2.getRadius() << endl;
  
  // Further test that the class compensates for invalid radius.
  // Attempt to modify the circle with a negative radius.
  // Again, it should change -5 to positive 5.
  cout << "Test set method, set circle2 to radius -5..." << endl;
  circle2.setRadius(-5);
  // Expected output:
  // radius = 5
  // area = 78.5398
  cout << "radius = " << circle2.getRadius() << endl;
  cout << "area = " << circle2.area() << endl;
  
  cout << "\n";
 // For Cylinder, there is no default constructor, only a
  // constructor that takes in a given radius and height.
  // The same error corrections found in Circle should be
  // implemented in the Cylinder class as well.
  // The -30 height should be changed to positive 30.
  cout << "Test Cylinder class given radius (20) and height (-30):" << endl;
  Cylinder cylinder1(20, -30);
  
  // Expected output:
  // Cylinder cylinder1: radius = 20; height = 30
  // surface area = 6283.19
  // volume = 37699.1
  cout << "Cylinder cylinder1: radius = " << cylinder1.getRadius();
  cout << "; height = " << cylinder1.getHeight() << endl;
  cout << "surface area = " << cylinder1.area() << endl;
  cout << "volume = " << cylinder1.volume() << endl;
  
  cout << "\n";
  
  // Test error correction of the mutator methods.
  // The 0 should be changed to a 1.
  // Expected output:
  // Test set method, set cylinder1 to radius 0 and height 0...
  // radius = 1; height = 1
  // surface area = 12.5664
  // volume = 3.14159
  cout << "Test set method, set cylinder1 to radius (0) and height (0)..." << endl;
  cylinder1.setRadius(0);
  cylinder1.setHeight(-1);
  cout << "radius = " << cylinder1.getRadius() << "; height = " << cylinder1.getHeight() << endl;
  cout << "surface area = " << cylinder1.area() << endl;
  cout << "volume = " << cylinder1.volume() << endl;

  return 0;
}

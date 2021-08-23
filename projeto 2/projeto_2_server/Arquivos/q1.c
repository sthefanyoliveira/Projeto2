#include<stdio.h>
#include<math.h>



#define PI 3.14	
float CompCircunferencia(float r){
	
	//2 pir
	float circunferencia = 2*PI * r; 
	
	return circunferencia;
}
	float areaCircunferencia(float r){
	
	float areacircunferencia = PI * pow(r,2); 
	
	return areacircunferencia;
}



int main (void)
{
	
	
	
	
	
	printf("%f", areaCircunferencia(15));
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	return 0;
}


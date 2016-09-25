#define EMG A0
#define LOOPS 30
int reading[10];
int loops = LOOPS;
int store[LOOPS];
int a[5];
int Time = 0;
int finalReading = 0;
byte multiplier = 1;

void setup(){
  Serial.begin(9600);
}

void loop(){
  //run for 10 seconds 
 
while (Time < loops) {
  for(int i = 0; i < 10; i++){
    reading[i] = analogRead(EMG) * multiplier;
    delay(2);
  }
  for(int i = 0; i < 10; i++){
    finalReading += reading[i];
  }
  finalReading /= 10;

  Serial.print("Value = ");
  Serial.println(finalReading);

  //store value into array storage
  store[Time] = finalReading; 

 
  delay(1000);

  Time += 1; 
  
}
Serial.print("\n");
int threshhold = 37;
int f[6];
// average storage 0 to 4
int s = averagearrays (0, 4);
Serial.print("Average of 1st five seconds = ");
Serial.println(s);

// average storage 5 to 9
int t = averagearrays (5, 9);
Serial.print("Average of 2nd five seconds  = ");
Serial.println(t);

// average storage 10 to 14
int u = averagearrays (10, 14);
Serial.print("Average of 3rd five seconds  = ");
Serial.println(u);

// average storage 15 to 19
int v = averagearrays (15, 19);
Serial.print("Average of 4th five seconds = ");
Serial.println(v);

// average storage 20 to 24
int w = averagearrays (20, 24);
Serial.print("Average of 5th five seconds  = ");
Serial.println(w);

// average storage 25 to 29
int x = averagearrays (25, 29);
Serial.print("Average of 6th five seconds = ");
Serial.println(x);

//average of all of them 
int y = averagearrays (0, 29);
Serial.print("Average of all of them = ");
Serial.println(y);


//creates password matrix
int b[6] = {s, t, u, v, w, x};
for (int i = 0; i <= 5; i++)
{
 if (b[i] < threshhold)
 {
  f[i] = 0;
 }
 else f[i] = 1; 
 }

Serial.print("\n");
Serial.print("The password combo is:");
Serial.print("\n");
for (int i = 0; i <= 5; i++ ) {
    Serial.println(f[i]);
}

int z = getmax(store);

Serial.print("Max Value = ");
Serial.println(z);

while(1);
}


int averagearrays (int x, int y)
{
  a[0] = {0};
  for (int n = x; n <= y; n++) {
  a[0] += store[n]; 
  }
  return a[0]/(y-x+1); 
}

int getmax (int arr[]) {
  int max_val = arr[0];
  int i = 0;
  for(i = 1; i<LOOPS;i++){
    
      if(arr[i]>=max_val){
          max_val = arr[i];
      }
  }
  return max_val;
}








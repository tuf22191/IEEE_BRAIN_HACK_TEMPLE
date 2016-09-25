using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Net.Http;

using Xamarin.Forms;

namespace PasswordAuthorizor
{
    public partial class LogInScreen : ContentPage
    {
        public LogInScreen()
        {
            //InitializeComponent is a method gnenerated during the build process. 
            //Xaml file is parsed one during Build process and packaged in the .dll and then parsed again at runtime
           
            InitializeComponent();
        }
       async void DownloadPageAsync()
        {
            // ... Target page.
            string page = "http://10.109.140.60:8000/info";

            // ... Use HttpClient.
            using (HttpClient client = new HttpClient())
            using (HttpResponseMessage response = await client.GetAsync(page))
            using (HttpContent content = response.Content)
            {
                // ... Read the string.
                string result = await content.ReadAsStringAsync();

                // ... Display the result.
                if (result != null &&
                result.Length >= 50)
                {
                    labelChanger.Text = result;
                }
            }
        }
        void onButtonClicked(object sender, EventArgs args)
        {
            DownloadPageAsync();
           // loginButton.Text = "Button was clicked!";
        }


    }
}

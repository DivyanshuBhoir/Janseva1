package eu.tutorials.timepass

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.text.style.BackgroundColorSpan
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun project(
    navController: NavHostController
){
    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult())
    { _ ->
    }

    val boldTextStyle = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp // You can adjust the font size as needed
    )
Column(modifier = Modifier
    .fillMaxSize()
    .padding(8.dp), 
    verticalArrangement = Arrangement.Center, 
    horizontalAlignment = Alignment.CenterHorizontally
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Top

    ) {
        Box {
            Image(painter = painterResource(id = R.drawable.untitled),
                contentDescription =null
                , modifier = Modifier.fillMaxSize()
                , contentScale = ContentScale.FillBounds
            )

            Scaffold(modifier = Modifier
                .fillMaxSize()
                .padding(8.dp), topBar = {
                Text(
                    text = "welcome to JaanSeva", color = Color.Red,
                    textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth()
                    , fontSize = TextUnit.Unspecified,style = boldTextStyle
                )

            }, floatingActionButton =
            {
                Icons.Default.Add
            },
                floatingActionButtonPosition = FabPosition.Center,
                containerColor = Color.Transparent, content = {
                    Column() {
                        Box(modifier = Modifier.padding(20.dp)) {

                            Button(
                                onClick = {
                                    openUrl(context, "https://uidai.gov.in/en/my-aadhaar/get-aadhaar.html  ")
                                },
                                modifier = Modifier
                                    .padding(20.dp)
                                    .align(Alignment.TopStart),
                                shape = ButtonDefaults.elevatedShape,
                                colors = ButtonDefaults.buttonColors(Color.Cyan)

                            ) {
                                Text(text = "Aadhar Card")
                            }
                            Button(
                                onClick = { navController.navigate("shoppinglistscreen") },
                                modifier = Modifier
                                    .padding(20.dp)
                                    .align(Alignment.TopEnd),
                                shape = ButtonDefaults.elevatedShape,
                                colors = ButtonDefaults.buttonColors(Color.Cyan)

                            ) {
                                Text(text = "Road seva")
                            }


                            Button(
                                onClick = { navController.navigate( "EcoBricksList") },
                                modifier = Modifier
                                    .padding(20.dp)
                                    .align(Alignment.CenterStart),
                                shape = ButtonDefaults.elevatedShape,
                                colors = ButtonDefaults.buttonColors(Color.Cyan)

                            ) {
                                Text(text = "ECOBRICKS")
                            }
                            Button(
                                onClick = { /*TODO*/ },
                                modifier = Modifier
                                    .padding(20.dp)
                                    .align(Alignment.CenterEnd),
                                shape = ButtonDefaults.elevatedShape,
                                colors = ButtonDefaults.buttonColors(Color.Cyan)

                            ) {
                                Text(text = "Otherseva")
                            }

                            Button(
                                onClick = { /*TODO*/ },
                                modifier = Modifier
                                    .padding(200.dp)
                                    .align(Alignment.BottomStart),
                                shape = ButtonDefaults.elevatedShape,
                                colors = ButtonDefaults.buttonColors(Color.Cyan)

                            ) {
                                Text(text = "Otherseva")
                            }
                        }
                    }
                }
            )
        }
    }
}

}

fun openUrl(context: android.content.Context, url: String) {
    try {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        // Handle if no activity can handle the intent
    }
}

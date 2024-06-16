package com.example.docreserva.ui.theme.fragment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.docreserva.R
import com.example.docreserva.model.DocModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeFragment() {
    val inputvalue = remember { mutableStateOf(TextFieldValue()) }
    val sampleItems = ArrayList<DocModel>()
    sampleItems.add(DocModel(R.drawable.general, "General"))
    sampleItems.add(DocModel(R.drawable.nepphrologist, "Nephrologist"))
    sampleItems.add(DocModel(R.drawable.cardiology, "Cardiology"))
    sampleItems.add(DocModel(R.drawable.neurologist, "Neurologist"))
    sampleItems.add(DocModel(R.drawable.dentist, "Dentist"))
    sampleItems.add(DocModel(R.drawable.gynecologist, "Gynecologist"))
    sampleItems.add(DocModel(R.drawable.pediatrician, "Pediatrician"))
    sampleItems.add(DocModel(R.drawable.surgeon, "G surgeon"))
    val boldFontFamily = FontFamily(Font(R.font.montserrat_bold))
    val mediumFontFamily = FontFamily(Font(R.font.montserrat_medium))
    ConstraintLayout(modifier = Modifier.background(color = colorResource(id = R.color.background_color))) {
        val (profileImage, userName, greeting, notificationIcon, locationIcon, yourLocation, address, searchBox, banner, topDoc, viewAll, lazyListTopDoc) = createRefs()
        Image(painter = painterResource(id = R.drawable.profileimage),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .constrainAs(profileImage) {
                    top.linkTo(parent.top, margin = 70.dp)
                    start.linkTo(parent.start, margin = 20.dp)
                }
                .size(60.dp)
                .clip(CircleShape))
        Text(
            text = "hi, Christopher", modifier = Modifier.constrainAs(userName) {
                top.linkTo(profileImage.top, margin = 5.dp)
                start.linkTo(profileImage.end, margin = 10.dp)
            }, style = TextStyle(
                fontFamily = boldFontFamily,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = colorResource(id = R.color.app_theme_dark_color)
            )
        )
        Text(
            text = "Good Morning", modifier = Modifier.constrainAs(greeting) {
                top.linkTo(userName.bottom, margin = 5.dp)
                start.linkTo(userName.start)
            }, style = TextStyle(
                fontFamily = mediumFontFamily, color = colorResource(id = R.color.app_theme_color)
            )
        )
        Image(painter = painterResource(id = R.drawable.notification_icon),
            contentDescription = "",
            Modifier.constrainAs(notificationIcon) {
                top.linkTo(userName.top)

                end.linkTo(parent.end, 20.dp)
            })
        Image(painter = painterResource(id = R.drawable.location_icon),
            contentDescription = "",
            modifier = Modifier.constrainAs(locationIcon) {
                top.linkTo(notificationIcon.top)
                end.linkTo(notificationIcon.start, margin = 15.dp)
            })
        Text(text = "Your Location", style = TextStyle(
            fontFamily = mediumFontFamily, color = colorResource(
                id = R.color.gray
            ), fontSize = 12.sp
        ), modifier = Modifier.constrainAs(yourLocation) {
            top.linkTo((locationIcon.top))
            end.linkTo(locationIcon.start, 10.dp)
        })
        Text(text = "West Ham", style = TextStyle(
            fontFamily = boldFontFamily, color = colorResource(
                id = R.color.app_theme_dark_color
            ), fontSize = 14.sp
        ), modifier = Modifier.constrainAs(address) {
            top.linkTo((yourLocation.bottom))
            end.linkTo(locationIcon.start, 10.dp)
        })
        TextField(value = inputvalue.value,
            onValueChange = { inputvalue.value = it },
            placeholder = { Text(text = "Eg: “MIMS”", color = Color.Black) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search, contentDescription = null, tint = Color.Gray
                )
            },
            modifier = Modifier
                .constrainAs(searchBox) {
                    top.linkTo(profileImage.bottom, margin = 30.dp)
                    start.linkTo(profileImage.start)
                    end.linkTo(notificationIcon.end)
                    width = Dimension.fillToConstraints
                }
                .shadow(
                    elevation = 4.dp, shape = RoundedCornerShape(12.dp), clip = false
                )
                .height(56.dp)
                .background(
                    color = Color.Transparent, shape = RoundedCornerShape(12.dp)
                ), // Set to transparent here
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White, // Set background color here
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color.Black
            ),
            shape = RoundedCornerShape(12.dp),
            singleLine = true)
        Image(painter = painterResource(id = R.drawable.banner),
            contentDescription = "",
            modifier = Modifier
                .constrainAs(banner) {
                    top.linkTo(searchBox.bottom, margin = 20.dp)
                    start.linkTo(parent.start, margin = 7.dp)
                    end.linkTo(parent.end, margin = 5.dp)
                    width = Dimension.fillToConstraints

                }
                .fillMaxWidth())
        Text(
            text = "Top Doctors", modifier = Modifier.constrainAs(topDoc) {
                top.linkTo(banner.bottom, margin = 20.dp)
                start.linkTo(searchBox.start)
            }, style = TextStyle(
                fontFamily = mediumFontFamily, fontSize = 16.sp, color = colorResource(
                    id = R.color.black
                )
            )
        )
        Text(
            text = "View All", modifier = Modifier.constrainAs(viewAll) {
                top.linkTo(topDoc.top)
                end.linkTo(notificationIcon.end)
            }, style = TextStyle(
                fontFamily = mediumFontFamily,
                color = colorResource(id = R.color.app_theme_dark_color)
            )
        )
        LazyVerticalGrid(columns = GridCells.Fixed(4), // 4 columns in the grid
            modifier = Modifier
                .padding(16.dp)
                .constrainAs(lazyListTopDoc) {
                    top.linkTo(viewAll.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }) {
            items(sampleItems.size) { index ->
                GridItem(item = sampleItems[index])
            }
        }


    }

}

@Composable
fun GridItem(item: DocModel) {

    val boldFontFamily = FontFamily(Font(R.font.montserrat_bold))
    val mediumFontFamily = FontFamily(Font(R.font.montserrat_medium))
    ConstraintLayout(modifier = Modifier.background(color = colorResource(id = R.color.background_color))) {
        val (imgTypeOfDoc, txtDox) = createRefs()
        Image(painter = painterResource(id = item.image),
            contentDescription = "",
            contentScale = ContentScale.Fit,
            modifier = Modifier.constrainAs(imgTypeOfDoc) {
                top.linkTo(parent.top, margin = 20.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })
        Text(text = item.text, modifier = Modifier.constrainAs(txtDox) {
            top.linkTo(imgTypeOfDoc.bottom, margin = 0.dp)
            start.linkTo(imgTypeOfDoc.start)
            end.linkTo(imgTypeOfDoc.end)
        }, style = TextStyle(fontFamily = mediumFontFamily, fontSize = 11.sp))

    }
}


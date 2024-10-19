package com.doimaginative.edupaytracker

import android.app.DatePickerDialog
import android.graphics.drawable.Icon
import android.os.Bundle
import android.widget.DatePicker
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.Icon
import androidx.compose.material.LocalAbsoluteElevation
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.doimaginative.edupaytracker.ui.theme.EduPayTrackerTheme
import java.net.DatagramPacket
import java.util.Calendar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EduPayTrackerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    var studentName by remember { mutableStateOf("") }
//                    var studentName by remember { mutableStateOf("") }
//                    var studentName by remember { mutableStateOf("") }
//                    var studentName by remember { mutableStateOf("") }
//                    var studentName by remember { mutableStateOf("") }
//                    StudentTextField(studentName, { studentName = it },KeyboardType.Text, "Enter Name")


                }
            }
        }
    }
}


@Composable
fun StudentTextField(value: String, onValueChange: (String) -> Unit, keyboardType: KeyboardType, placeHolder:String){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp) // Fixed Space of 16 dp between the items in the column
    ) {
        Column{
            Text(text = "Name",
                modifier = Modifier.padding(start = 10.dp ))
            TextField(
                value = value ,
                onValueChange = onValueChange,
                modifier = Modifier
                    .border(BorderStroke(1.dp, Color.Black), shape = RoundedCornerShape(20))
                    .fillMaxWidth(),
                placeholder = { Text(placeHolder) },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    cursorColor = Color.Black,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp) // Equal space between columns
        ) {

            Column(
                modifier = Modifier.weight(1f)
            ){
                Text(text = "Class",
                    modifier = Modifier.padding(start = 10.dp ))
                DropDownMenuField("Select Class")
            }
            Column(
                modifier = Modifier.weight(1f)
            ){
                Text(text = "Board",
                    modifier = Modifier.padding(start = 10.dp ))
                DropDownMenuField("Select Board")
            }
        }
        Column{
            Text(text = "School Name",
                modifier = Modifier.padding(start = 10.dp ))
            TextField(
                value = value ,
                onValueChange = onValueChange,
                modifier = Modifier
                    .border(BorderStroke(1.dp, Color.Black), shape = RoundedCornerShape(20))
                    .fillMaxWidth(),
                placeholder = { Text("Enter School Name") },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    cursorColor = Color.Black,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp) // Equal space between columns
        ) {

            Column(
                modifier = Modifier.weight(1f)
            ){
                Text(text = "Date of Joining",
                    modifier = Modifier.padding(start = 10.dp ))
                DataPickerDialog()
            }
            Column(
                modifier = Modifier.weight(1f)
            ){
                Text(text = "Tuition Fee",
                    modifier = Modifier.padding(start = 10.dp ))
                TextField(
                    value = value ,
                    onValueChange = onValueChange,
                    modifier = Modifier
                        .border(BorderStroke(1.dp, Color.Black), shape = RoundedCornerShape(20)),
                    placeholder = { Text("Enter Fee") },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                        cursorColor = Color.Black,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                )
            }
        }

        Button(
            onClick = { },
            modifier = Modifier
                .border(BorderStroke(1.dp, Color.Black), shape = RoundedCornerShape(20))
                .fillMaxWidth(),
            colors =  ButtonDefaults.buttonColors(
                backgroundColor = Color.Transparent,
                contentColor = Color.Black
            ),
            elevation = null
        ){ Text("DELETE")}

        Button(
            onClick = { },
            modifier = Modifier
                .background(color = Color.Black)
                .border(BorderStroke(1.dp, Color.Black), shape = RoundedCornerShape(20))
                .fillMaxWidth(),
            colors =  ButtonDefaults.buttonColors(
                backgroundColor = Color.Black,
                contentColor = Color.White
            ),
            elevation = null
        ){ Text("SAVE")}
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DropDownMenuField(label: String){

    var expanded by remember {
        mutableStateOf(false)
    }

    var selectedClass by remember {
        mutableStateOf(label)
    }

    val classList = (1..12).map { "${it}${when (it) {
        1 -> "st"
        2 -> "nd"
        3 -> "rd"
        else -> "th"
    }}" }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        TextField(
            value = selectedClass,
            onValueChange = { },
            readOnly = true,
            modifier = Modifier
                .border(BorderStroke(1.dp, Color.Black), shape = RoundedCornerShape(20)),
            placeholder = { Text(label) },
            trailingIcon = {
                           ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false}
        ) {
            classList.forEach {
                DropdownMenuItem(
                    onClick = {
                        selectedClass = it
                        expanded = false
                    }) {
                }
            }
        }
    }
}

@Composable
fun DataPickerDialog()
{
    var selectedDate by remember { mutableStateOf("Select Date") }
    val calendar = Calendar.getInstance()
    val year = Calendar.YEAR
    val month = Calendar.MONTH
    val day = Calendar.DAY_OF_MONTH

    val context = LocalContext.current

    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, selectedYear:Int, selectedMonth: Int, selectedDay: Int ->
            selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
        },year, month, day
    )
    TextField(
        value = selectedDate ,
        onValueChange = { },
        modifier = Modifier
            .border(BorderStroke(1.dp, Color.Black), shape = RoundedCornerShape(20))
            .clickable { datePickerDialog.show() },
        placeholder = { Text("Select Date") },
        readOnly = true,
        trailingIcon = { Icon(
            imageVector = Icons.Default.DateRange,
            contentDescription = "Select Date",
            modifier = Modifier.clickable { datePickerDialog.show() }
        )},
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
            cursorColor = Color.Black,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EduPayTrackerTheme {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var studentName by remember { mutableStateOf("") }
            StudentTextField(studentName, { studentName = it },KeyboardType.Text, "Enter Name")
        }
    }
}
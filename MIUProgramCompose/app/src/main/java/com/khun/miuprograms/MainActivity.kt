package com.khun.miuprograms

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.khun.miuprograms.data.Program
import com.khun.miuprograms.data.programs
import com.khun.miuprograms.ui.theme.MIUProgramsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MIUProgramsTheme {
                //A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    
                    MIUPrograms(list = programs)
                }
            }
        }
    }
}

@Composable
fun MIUPrograms(list: List<Program>){
    LazyColumn {
        items(list){program ->
            ProgramCard(program = program)
        }
    }
}

@Composable
fun ProgramCard(program: Program){
    Row (modifier = Modifier.padding(10.dp)) {
        Image(
            painter = painterResource(id = R.drawable.miu_logo),
            contentDescription = null,
            modifier = Modifier
                .clip(CircleShape)
                .size(100.dp)
                .border(1.dp, Color.Blue, CircleShape))

        Spacer(modifier = Modifier.width(10.dp))

        //create a mutable state variable that trigger UI updates when its value changes
        var isExpanded by remember {
            mutableStateOf(false)
        }
        Column (modifier = Modifier
            .clickable { isExpanded = !isExpanded }){
            Text(text = program.name,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = program.description,
                maxLines = if(isExpanded) Int.MAX_VALUE else 3,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MIUProgramsPreview() {
    MIUProgramsTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background) {
            MIUPrograms(programs)
        }
    }
}

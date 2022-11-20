package com.king.compose.codetextfield.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.king.compose.codetextfield.CodeTextField
import com.king.compose.codetextfield.app.ui.theme.CodeTextFieldTheme

/**
 * 演示 CodeTextField
 *
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodeTextFieldTheme {
                MainScreen()
            }
        }
    }
}

@Composable
private fun MainScreen() {
    Scaffold(topBar = {
        TopAppBar {
            Text(
                text = stringResource(id = R.string.app_name),
                style = TextStyle(fontSize = 24.sp, color = Color.White),
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = it.calculateBottomPadding()),
            color = MaterialTheme.colors.background
        ) {
            CodeTextFiledDemo()
        }
    }

}

/**
 * 验证码示例
 */
@Composable
private fun CodeTextFiledDemo() {
    Column() {
        val text1 = remember {
            mutableStateOf("")
        }
        // 验证码矩形输入框；默认
        CodeTextField(
            value = text1.value,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            onValueChange = {
                text1.value = it
            })

        val text2 = remember {
            mutableStateOf("")
        }
        // 验证码矩形输入框；移除光标颜色
        CodeTextField(
            value = text2.value,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            onValueChange = {
                text2.value = it
            },
            cursorBrush = SolidColor(Color.Unspecified)
        )

        val text3 = remember {
            mutableStateOf("")
        }
        // 验证码圆角输入框；自定义输入框颜色
        CodeTextField(
            value = text3.value,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            onValueChange = {
                text3.value = it
            },
            cursorBrush = SolidColor(Color.Unspecified),
            boxShape = RoundedCornerShape(10.dp),
            boxFocusedBorderStroke = BorderStroke(
                TextFieldDefaults.FocusedBorderThickness,
                color = Color.Red
            ),
        )

        val text4 = remember {
            mutableStateOf("")
        }
        // 验证码圆角带背景输入框；突出输入的验证码以加密“*”的方式显示
        CodeTextField(
            value = text4.value,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            textStyle = TextStyle(
                fontSize = 24.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            ),
            onValueChange = {
                text4.value = it
            },
            cursorBrush = SolidColor(Color.Unspecified),
            boxShape = RoundedCornerShape(10.dp),
            boxBackgroundColor = Color.LightGray,
            cipherMask = "*"
        )

        val text5 = remember {
            mutableStateOf("")
        }
        // 验证码矩形无间距输入框
        CodeTextField(
            value = text5.value,
            modifier = Modifier
                .padding(horizontal = 30.dp, vertical = 10.dp)
                .border(BorderStroke(2.dp, color = Color.LightGray)),
            onValueChange = {
                text5.value = it
            },
            cursorBrush = SolidColor(Color.Red),
            boxBorderStroke = BorderStroke(1.dp, color = Color.LightGray),
            boxFocusedBorderStroke = BorderStroke(
                1.dp,
                color = Color.LightGray
            ),
            boxMargin = 0.dp
        )

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CodeTextFieldTheme {
        MainScreen()
    }
}
package com.king.compose.codetextfield

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * 验证码输入框
 *
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
@Composable
fun CodeTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier.padding(10.dp),
    textColor: Color = Color.Unspecified,
    length: Int = 6,
    boxWidth: Dp = 48.dp,
    boxHeight: Dp = 48.dp,
    boxMargin: Dp = 10.dp,
    boxShape: Shape = RectangleShape,
    boxBackgroundColor: Color = Color.Unspecified,
    boxBorderStroke: BorderStroke = BorderStroke(
        width = TextFieldDefaults.UnfocusedBorderThickness,
        color = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled)
    ),
    boxFocusedBorderStroke: BorderStroke = BorderStroke(
        width = TextFieldDefaults.FocusedBorderThickness,
        color = MaterialTheme.colors.primary.copy(alpha = ContentAlpha.high)
    ),
    enabled: Boolean = true,
    textStyle: TextStyle = TextStyle(fontSize = 20.sp),
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Center,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    cursorBrush: Brush = SolidColor(TextFieldDefaults.textFieldColors().cursorColor(false).value),
    cipherMask: String = "",
) {
    val focusState = remember {
        mutableStateOf(false)
    }
    val textFieldValue = TextFieldValue(text = value, selection = TextRange(value.length))
    var lastTextValue by remember { mutableStateOf(value) }

    BasicTextField(
        value = textFieldValue,
        onValueChange = {
            val newText = if (it.text.length <= length) {
                it.text
            } else {// 输入超长时，截取前面的部分
                it.text.substring(0, length)
            }
            if (lastTextValue != newText) {
                lastTextValue = newText
                onValueChange(newText)
            }
        },
        modifier = Modifier.onFocusChanged {
            focusState.value = it.hasFocus
        },
        enabled = enabled,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = true,
        cursorBrush = SolidColor(Color.Unspecified)
    ) {
        CodeText(
            value = textFieldValue.text,
            modifier = modifier,
            textColor = textColor,
            hasFocus = focusState.value,
            length = length,
            boxWidth = boxWidth,
            boxHeight = boxHeight,
            boxMargin = boxMargin,
            boxShape = boxShape,
            boxBackgroundColor = boxBackgroundColor,
            boxBorderStroke = boxBorderStroke,
            boxFocusedBorderStroke = boxFocusedBorderStroke,
            textStyle = textStyle,
            cursorBrush = cursorBrush,
            horizontalArrangement = horizontalArrangement,
            cipherMask = cipherMask
        )
    }

}

/**
 * 验证码文本
 */
@Composable
private fun CodeText(
    value: String,
    modifier: Modifier = Modifier,
    textColor: Color = Color.Unspecified,
    hasFocus: Boolean = false,
    length: Int = 6,
    boxWidth: Dp = 48.dp,
     boxHeight: Dp = 48.dp,
    boxMargin: Dp = 10.dp,
    boxShape: Shape = RectangleShape,
    boxBackgroundColor: Color = Color.Gray,
    boxBorderStroke: BorderStroke = BorderStroke(1.dp, color = Color.Unspecified),
    boxFocusedBorderStroke: BorderStroke = boxBorderStroke,
    textStyle: TextStyle = TextStyle.Default,
    cursorBrush: Brush = SolidColor(Color.Unspecified),
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Center,
    cipherMask: String = "",
) {
    Row(modifier = modifier, horizontalArrangement = horizontalArrangement) {
        repeat(length) {
            if (boxMargin.value > 0 && it != 0) {
                // 框与框之间的间距
                Spacer(modifier = Modifier.width(boxMargin))
            }
            val selection = it == value.length

            // 验证码的框
            Box(
                modifier = Modifier
                    .background(color = boxBackgroundColor, boxShape)
                    .clip(boxShape)
                    .border(
                        if (hasFocus && selection) boxFocusedBorderStroke else boxBorderStroke,
                        boxShape
                    )
                    .size(width = boxWidth, height = boxHeight),
                contentAlignment = Alignment.Center
            ) {

                val text = value.getOrNull(it)?.toString() ?: ""

                val cursorRectState = remember {
                    mutableStateOf(Rect(0f, 0f, 0f, 0f))
                }

                // 框的文本内容
                Text(
                    text = if (cipherMask.isNotEmpty() && text.isNotEmpty()) cipherMask else text,
                    modifier = Modifier.cursor(
                        cursorBrush = cursorBrush,
                        cursorRect = cursorRectState.value,
                        enabled = hasFocus && selection
                    ),
                    color = textColor,
                    onTextLayout = { textLayoutResult ->
                        cursorRectState.value = textLayoutResult.getCursorRect(0)
                    },
                    style = textStyle
                )
            }
        }
    }
}



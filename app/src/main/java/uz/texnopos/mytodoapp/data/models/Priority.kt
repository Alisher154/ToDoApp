package uz.texnopos.mytodoapp.data.models

import androidx.compose.ui.graphics.Color
import uz.texnopos.mytodoapp.ui.theme.HighPriorityColor
import uz.texnopos.mytodoapp.ui.theme.LowPriorityColor
import uz.texnopos.mytodoapp.ui.theme.MediumPriorityColor
import uz.texnopos.mytodoapp.ui.theme.NonePriorityColor

enum class Priority(val color:Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}
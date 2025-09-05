package com.jetpackmsm.mylearningappone.components.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

val smallSize = 75.dp
val bigSize = 175.dp

@Composable
fun FirstConstraintlayout(modifier: Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (boxRed, boxGray, boxGreen, boxMagenta, boxYellow) = createRefs()

        Box(
            Modifier
                .size(150.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {})
        Box(
            Modifier
                .size(150.dp)
                .background(Color.Gray)
                .constrainAs(boxGray) {})
        Box(
            Modifier
                .size(150.dp)
                .background(Color.Green)
                .constrainAs(boxGreen) {})
        Box(
            Modifier
                .size(150.dp)
                .background(Color.Magenta)
                .constrainAs(boxMagenta) {})
        Box(
            Modifier
                .size(150.dp)
                .background(Color.Yellow)
                .constrainAs(boxYellow) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })

    }
}

@Composable
fun FirstExerciseConstraintlayout(modifier: Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (sBoxYellow, sBoxMagenta, sBoxGreen, sBoxGray, sBoxRed) = createRefs()
        val (bBoxBlue, bBoxDarkGray, bBoxCyan) = createRefs()
        val sBoxBlack = createRef()

        // Big Blue Box
        BigBox(Modifier.constrainAs(bBoxBlue) {
            top.linkTo(sBoxYellow.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }, Color.Blue)

        // Yellow Small Box
        SmallBox(
            Modifier
                .constrainAs(sBoxYellow) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }, Color.Yellow
        )

        // Magenta Small Box
        SmallBox(
            Modifier
                .constrainAs(sBoxMagenta) {
                    end.linkTo(sBoxYellow.start)
                    bottom.linkTo(sBoxYellow.top)
                }, Color.Magenta
        )

        // Green Small Box
        SmallBox(Modifier.constrainAs(sBoxGreen) {
            start.linkTo(sBoxYellow.end)
            bottom.linkTo(sBoxYellow.top)
        }, Color.Green)

        // Gray Small Box
        SmallBox(Modifier.constrainAs(sBoxGray) {
            end.linkTo(sBoxYellow.start)
            top.linkTo(sBoxYellow.bottom)
        }, Color.Gray)

        // Red Small Box
        SmallBox(Modifier.constrainAs(sBoxRed) {
            start.linkTo(sBoxYellow.end)
            top.linkTo(sBoxYellow.bottom)
        }, Color.Red)

        // Big Cyan Box
        BigBox(Modifier.constrainAs(bBoxCyan) {
            end.linkTo(sBoxMagenta.end)
            bottom.linkTo(sBoxMagenta.top)
        }, Color.Cyan)

        // Small Black Box
        SmallBox(Modifier.constrainAs(sBoxBlack) {
            start.linkTo(bBoxCyan.end)
            top.linkTo(bBoxCyan.top)
            bottom.linkTo(bBoxCyan.bottom)
        }, Color.Black)

        // Big DarkGray Box
        BigBox(Modifier.constrainAs(bBoxDarkGray) {
            start.linkTo(sBoxBlack.end)
            top.linkTo(bBoxCyan.top)
            bottom.linkTo(bBoxCyan.bottom)
        }, Color.DarkGray)
    }
}

@Preview
@Composable
fun PreviewConstrainExercise() {
    FirstExerciseConstraintlayout(Modifier)
}


@Composable
fun SmallBox(modifier: Modifier, color: Color) {
    Box(
        modifier = modifier
            .background(color)
            .size(smallSize)
    )
}

@Composable
fun BigBox(modifier: Modifier, color: Color) {
    Box(
        modifier = modifier
            .background(color)
            .size(bigSize)
    )
}

@Composable
fun ConstraintGuideline(modifier: Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val fromTopGuideLine = createGuidelineFromTop(0.1f)
        val redBox = createRef()

        Box(Modifier
            .size(50.dp)
            .background(Color.Red)
            .constrainAs(redBox) {
                top.linkTo(fromTopGuideLine)
                start.linkTo(parent.start)
            })

    }
}

@Composable
fun ConstraintBarrier(modifier: Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (boxRed, boxCyan, boxYellow) = createRefs()
        val barrier = createEndBarrier(boxRed, boxCyan)

        Box(Modifier
            .size(65.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            })

        Box(Modifier
            .size(156.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                top.linkTo(boxRed.bottom, margin = 40.dp)
                start.linkTo(parent.start, margin = 32.dp)
            })

        Box(Modifier
            .size(70.dp)
            .background(Color.Cyan)
            .constrainAs(boxCyan) {
                start.linkTo(barrier)
            })
    }
}


@Composable
fun ConstrainChain(modifier: Modifier) {
    ConstraintLayout(modifier = modifier) {
        val (boxCyan, boxYellow, boxGreen) = createRefs()

        // Va a juntar los elementos uno despues del otro por el ChainStyel.Packed
        createVerticalChain(boxCyan, boxYellow, boxGreen, chainStyle = ChainStyle.Packed)
    }
}
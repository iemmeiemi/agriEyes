package com.example.agrieyes.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

val primaryDarkColor: Color = Color(0xFF263238)

/**
 * Display an initial empty state or swipe to refresh content.
 *
 * @param loading (state) when true, display a loading spinner over [content]
 * @param empty (state) when true, display [emptyContent]
 * @param emptyContent (slot) the content to display for the empty state
 * @param onRefresh (event) event to request refresh
 * @param modifier the modifier to apply to this layout.
 * @param content (slot) the main content to show
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LoadingContent(
    loading: Boolean,
    empty: Boolean,
    emptyContent: @Composable () -> Unit,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    if (!empty) {
        emptyContent()
    } else {
        // Thay thế SwipeRefresh bằng pullRefresh
        val pullRefreshState = rememberPullRefreshState(loading, onRefresh)

        Box(modifier = modifier.pullRefresh(pullRefreshState)) {
            content()

            // Thêm PullRefreshIndicator để hiển thị chỉ báo tải lại
            PullRefreshIndicator(state = pullRefreshState, refreshing = loading)
        }
    }
}

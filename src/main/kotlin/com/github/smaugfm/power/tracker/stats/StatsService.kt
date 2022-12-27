package com.github.smaugfm.power.tracker.stats

import com.github.smaugfm.power.tracker.events.Event
import kotlinx.coroutines.flow.Flow

interface StatsService {
    fun calculateEventStats(event: Event): Flow<EventStats>
}

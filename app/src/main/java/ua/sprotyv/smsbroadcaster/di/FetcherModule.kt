package ua.sprotyv.smsbroadcaster.di

import org.koin.dsl.module
import retrofit2.Retrofit
import ua.sprotyv.smsbroadcaster.feature.fetcher.data.BroadcastApiService
import ua.sprotyv.smsbroadcaster.feature.fetcher.data.BroadcastFetcherApiSource
import ua.sprotyv.smsbroadcaster.feature.fetcher.domain.BroadcastFetcherSource
import ua.sprotyv.smsbroadcaster.feature.fetcher.domain.FetcherRepository

val fetcherModule = module {
    factory { get<Retrofit>().create(BroadcastApiService::class.java) }
    factory<BroadcastFetcherSource> { BroadcastFetcherApiSource(get()) }
    factory { FetcherRepository(get()) }
}
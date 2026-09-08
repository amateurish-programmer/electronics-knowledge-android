package com.github.amateurishprogrammer.electronicsknowledge.domain
import java.text.Normalizer
import java.util.Locale
data class SearchCandidate(val id:String,val title:String,val englishName:String,val aliases:List<String>,val keywords:List<String>,val summary:String)
object SearchRanker{private fun String.n()=Normalizer.normalize(this,Normalizer.Form.NFKC).lowercase(Locale.ROOT);fun rank(entries:List<SearchCandidate>,query:String):List<SearchCandidate>{val q=query.n().trim();if(q.isBlank())return entries;return entries.mapIndexedNotNull{i,e->val t=e.title.n();val en=e.englishName.n();val a=e.aliases.map{it.n()};val score=when{t==q||en==q->400;q in a->300;t.startsWith(q)||en.startsWith(q)->200;(listOf(t,en)+a+e.keywords.map{it.n()}+e.summary.n()).any{q in it}->100;else->0};if(score==0)null else Triple(e,score,i)}.sortedWith(compareByDescending<Triple<SearchCandidate,Int,Int>>{it.second}.thenBy{it.third}).map{it.first}}}

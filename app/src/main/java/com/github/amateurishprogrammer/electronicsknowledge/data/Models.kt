package com.github.amateurishprogrammer.electronicsknowledge.data
import kotlinx.serialization.Serializable
@Serializable data class ContentManifest(val schemaVersion:Int,val contentVersion:String,val generatedAt:String,val entryCount:Int,val sha256:String)
@Serializable data class Category(val id:String,val parentId:String?=null,val title:String,val sortOrder:Int)
@Serializable data class ContentSection(val title:String,val body:String)
@Serializable data class ImageRef(val assetPath:String,val altText:String,val attribution:String,val license:String)
@Serializable data class SourceRef(val title:String,val publisher:String,val url:String,val accessedAt:String)
@Serializable data class KnowledgeEntry(val id:String,val kind:String,val title:String,val englishName:String,val aliases:List<String>,val categoryId:String,val summary:String,val keywords:List<String>,val sections:List<ContentSection>,val images:List<ImageRef>,val relatedIds:List<String>,val sources:List<SourceRef>)
@Serializable data class ContentBundle(val manifest:ContentManifest,val categories:List<Category>,val entries:List<KnowledgeEntry>)

package io.holunda.webmodeler.rest.impl

import org.openapitools.client.model.*
import java.util.*

interface CamundaWebModelerClient {
    fun modifyCollaborator(createCollaboratorDto: CreateCollaboratorDto)
    fun searchCollaborators(pubSearchDtoProjectCollaboratorDto: PubSearchDtoProjectCollaboratorDto): PubSearchResultDtoProjectCollaboratorDto
    fun deleteCollaborator(projectId: UUID, email: String)


    fun getFile(fileId: UUID): FileDto
    fun createFile(createFileDto: CreateFileDto): FileMetadataDto
    fun deleteFile(fileId: UUID)
    fun searchFiles(pubSearchDtoFileMetadataDto: PubSearchDtoFileMetadataDto): PubSearchResultDtoFileMetadataDto


    fun createFolder(createFolderDto: CreateFolderDto): FolderMetadataDto
    fun deleteFolder(folderId: UUID)
    fun getFolder(folderId: UUID): FolderDto
    fun patchFolder(folderId: UUID, updateFolderDto: UpdateFolderDto): FolderMetadataDto


    fun getInfo(): InfoDto


    fun compareMilestones(milestone1Id: UUID, milestone2Id: UUID): MilestoneComparisonDto
    fun createMilestone(createMilestoneDto: CreateMilestoneDto): MilestoneMetadataDto
    fun deleteMilestone(milestoneId: UUID)
    fun getMilestone(milestoneId: UUID): MilestoneDto
    fun patchMilestone(milestoneId: UUID, updateMilestoneDto: UpdateMilestoneDto): MilestoneMetadataDto
    fun restoreMilestone(milestoneId: UUID): MilestoneMetadataDto
    fun searchMilestones(pubSearchDtoMilestoneMetadataDto: PubSearchDtoMilestoneMetadataDto): PubSearchResultDtoMilestoneMetadataDto


    fun createProject(createProjectDto: CreateProjectDto): ProjectMetadataDto
    fun deleteProject(projectId: UUID)
    fun getProject(projectId: UUID): ProjectDto
    fun searchProjects(pubSearchDtoProjectMetadataDto: PubSearchDtoProjectMetadataDto): PubSearchResultDtoProjectMetadataDto
    fun updateProject(projectId: UUID, updateProjectDto: UpdateProjectDto): ProjectMetadataDto

}
package io.holunda.webmodeler.rest.impl

import io.holunda.webmodeler.rest.auth.BearerAuth
import org.openapitools.client.ApiClient
import org.openapitools.client.api.*
import org.openapitools.client.auth.Authentication
import org.openapitools.client.model.*
import java.util.*

/**
 * Facade that implements the modeler functions from the CamundaWebModelerClient interface and delegates the api calls
 * to the generated API clients
 */
class CamundaWebModelerClientImpl(clientId: String, clientSecret: String) :
    CamundaWebModelerClient {
    private val apiClient: ApiClient

    private val milestonesApi: MilestonesApi
    private val collaboratorsApi: CollaboratorsApi
    private val filesApi: FilesApi
    private val foldersApi: FoldersApi
    private val infoApi: InfoApi
    private val projectsApi: ProjectsApi

    init {
        val authenticationMap = mapOf<String, Authentication>("Bearer" to BearerAuth(clientId, clientSecret))
        this.apiClient = ApiClient(authenticationMap)
        this.milestonesApi = MilestonesApi(apiClient)
        this.collaboratorsApi = CollaboratorsApi(apiClient)
        this.filesApi = FilesApi(apiClient)
        this.foldersApi = FoldersApi(apiClient)
        this.infoApi = InfoApi(apiClient)
        this.projectsApi = ProjectsApi(apiClient)
    }

    override fun modifyCollaborator(createCollaboratorDto: CreateCollaboratorDto) {
        collaboratorsApi.modifyCollaborator(createCollaboratorDto)
    }

    override fun searchCollaborators(pubSearchDtoProjectCollaboratorDto: PubSearchDtoProjectCollaboratorDto): PubSearchResultDtoProjectCollaboratorDto {
        return collaboratorsApi.searchCollaborators(pubSearchDtoProjectCollaboratorDto)
    }

    override fun deleteCollaborator(projectId: UUID, email: String) {
        collaboratorsApi.deleteCollaborator(projectId, email)
    }

    override fun getFile(fileId: UUID): FileDto {
        return filesApi.getFile(fileId)
    }

    override fun createFile(createFileDto: CreateFileDto): FileMetadataDto {
        return filesApi.createFile(createFileDto)
    }

    override fun deleteFile(fileId: UUID) {
        filesApi.deleteFile(fileId)
    }

    override fun searchFiles(pubSearchDtoFileMetadataDto: PubSearchDtoFileMetadataDto): PubSearchResultDtoFileMetadataDto {
        return filesApi.searchFiles(pubSearchDtoFileMetadataDto)
    }

    override fun createFolder(createFolderDto: CreateFolderDto): FolderMetadataDto {
        return foldersApi.createFolder(createFolderDto)
    }

    override fun deleteFolder(folderId: UUID) {
        foldersApi.deleteFolder(folderId)
    }

    override fun getFolder(folderId: UUID): FolderDto {
        return foldersApi.getFolder(folderId)
    }

    override fun patchFolder(folderId: UUID, updateFolderDto: UpdateFolderDto): FolderMetadataDto {
        return foldersApi.patchFolder(folderId, updateFolderDto)
    }

    override fun getInfo(): InfoDto {
        return infoApi.info
    }

    override fun compareMilestones(milestone1Id: UUID, milestone2Id: UUID): MilestoneComparisonDto {
        return milestonesApi.compareMilestones(milestone1Id, milestone2Id)
    }

    override fun createMilestone(createMilestoneDto: CreateMilestoneDto): MilestoneMetadataDto {
        return milestonesApi.createMilestone(createMilestoneDto)
    }

    override fun deleteMilestone(milestoneId: UUID) {
        milestonesApi.deleteMilestone(milestoneId)
    }

    override fun getMilestone(milestoneId: UUID): MilestoneDto {
        return milestonesApi.getMilestone(milestoneId)
    }

    override fun patchMilestone(milestoneId: UUID, updateMilestoneDto: UpdateMilestoneDto): MilestoneMetadataDto {
        return milestonesApi.patchMilestone(milestoneId, updateMilestoneDto)
    }

    override fun restoreMilestone(milestoneId: UUID): MilestoneMetadataDto {
        return milestonesApi.restoreMilestone(milestoneId)
    }

    override fun searchMilestones(pubSearchDtoMilestoneMetadataDto: PubSearchDtoMilestoneMetadataDto): PubSearchResultDtoMilestoneMetadataDto {
        return milestonesApi.searchMilestones(pubSearchDtoMilestoneMetadataDto)
    }

    override fun createProject(createProjectDto: CreateProjectDto): ProjectMetadataDto {
        return projectsApi.createProject(createProjectDto)
    }

    override fun deleteProject(projectId: UUID) {
        projectsApi.deleteProject(projectId)
    }

    override fun getProject(projectId: UUID): ProjectDto {
        return projectsApi.getProject(projectId)
    }

    override fun searchProjects(pubSearchDtoProjectMetadataDto: PubSearchDtoProjectMetadataDto): PubSearchResultDtoProjectMetadataDto {
        return projectsApi.searchProjects(pubSearchDtoProjectMetadataDto)
    }

    override fun updateProject(projectId: UUID, updateProjectDto: UpdateProjectDto): ProjectMetadataDto {
        return projectsApi.updateProject(projectId, updateProjectDto)
    }

}
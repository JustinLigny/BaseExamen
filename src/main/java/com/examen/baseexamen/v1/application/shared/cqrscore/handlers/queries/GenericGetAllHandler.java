package com.examen.baseexamen.v1.application.shared.cqrscore.handlers.queries;

import com.examen.baseexamen.v1.application.shared.cqrscore.entities.DbEntity;
import com.examen.baseexamen.v1.application.shared.cqrscore.exceptions.PaginationInvalidException;
import com.examen.baseexamen.v1.application.shared.cqrscore.exceptions.PaginationOutOfBoundsException;
import com.examen.baseexamen.v1.application.shared.cqrscore.interfaces.IEntityRepository;
import com.examen.baseexamen.v1.application.shared.cqrscore.interfaces.IQueryHandler;
import com.examen.baseexamen.v1.application.shared.cqrscore.outputs.EntityGetAllOutput;
import com.examen.baseexamen.v1.application.shared.cqrscore.outputs.EntityOutput;
import com.examen.baseexamen.v1.application.shared.cqrscore.queries.EntityGetAllQuery;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Collectors;

/**
 *  <h1>GenericGetAllHandler Class</h1> <br>
 *
 *  <p>The {@code GenericGetAllHandler} class is an abstract handler used
 *  to retrieve a list of entities, typically with pagination. It is designed
 *  to handle queries that require fetching multiple entities at once.</p> <br>
 *
 *  <p>This class extends {@code GenericQueryHandler} and implements the
 *  {@code IQueryHandler} interface. It leverages {@code IEntityRepository}
 *  to retrieve entities and uses {@code ModelMapper} to map the entities
 *  to their corresponding output DTOs.</p> <br>
 *
 *  <p>The {@code handle} method processes a query containing pagination
 *  information and returns the output DTO with the list of entities.
 *  If the page requested is invalid, a {@code PaginationOutOfBoundsException}
 *  is thrown.</p> <br>
 *
 *  @param <TDbEntity> The type of the database entity, extending {@code DbEntity}.
 *  @param <TCommand> The type of the query containing pagination information.
 *  @param <TOutputIntern> The type of the intern DTO to which the entities are mapped.
 *  @param <TOutput> The type of the output DTO containing the list of mapped entities.
 *
 *  @author Justin Ligny
 *  @since 1.0.1
 */
public abstract class GenericGetAllHandler<
        TDbEntity extends DbEntity,
        TCommand extends EntityGetAllQuery,
        TOutputIntern extends EntityOutput,
        TOutput extends EntityGetAllOutput<TOutputIntern>>
        extends GenericQueryHandler<TDbEntity, TOutput>
        implements IQueryHandler<TCommand, TOutput> {

    /**
     * The class type for the intern DTO used for mapping the entities.
     *
     * @since 1.0.1
     */
    private final Class<TOutputIntern> outputInternClass;

    /**
     * Constructor to initialize {@code GenericGetAllHandler} with required dependencies.
     *
     * @param repository The repository used to fetch the entities.
     * @param modelMapper The {@code ModelMapper} instance for mapping entities to DTOs.
     * @param outputInternClass The class type for the intern DTO.
     * @param outputClass The class type of the output DTO.
     *
     * @since 1.0.1
     */
    public GenericGetAllHandler(
            IEntityRepository<TDbEntity> repository,
            ModelMapper modelMapper,
            Class<TOutputIntern> outputInternClass,
            Class<TOutput> outputClass) {
        super(repository, modelMapper, outputClass);
        this.outputInternClass = outputInternClass;
    }

    /**
     * Handles the query to retrieve a list of entities based on pagination.
     *
     * @param input The query containing the pagination information.
     * @return The output DTO containing a list of mapped entities.
     * @throws PaginationOutOfBoundsException if the requested page is invalid.
     *
     * @since 1.0.1
     */
    @Override
    public final TOutput handle(TCommand input) {

        Pageable pageable = createPageableWithInput(input);

        Page<TDbEntity> page = retrieveEntities(input, pageable, repository);

        if(!page.hasContent() && input.page != 0)
            throw new PaginationOutOfBoundsException();

        List<TDbEntity> entitiesDatabase = page.getContent();

        afterEntityRetrieve(entitiesDatabase);

        List<TOutputIntern> entitiesOutputIntern = entitiesDatabase.stream()
                .map(e -> modelMapper.map(e, outputInternClass))
                .collect(Collectors.toList());

        TOutput output = createOutputInstance();
        output.addAll(entitiesOutputIntern);

        return output;
    }

    /**
     * <h1>createPageableWithInput Method</h1><br>
     *
     * <p>This method creates a {@link Pageable} object based on the input parameters from a given command object
     * (TCommand). It checks the validity of the pagination parameters, sets default values for sorting, and returns
     * a {@link Pageable} object that can be used in Spring Data repository queries.</p><br>
     *
     * <p>The method performs the following steps:</p>
     * <ul>
     *   <li>It verifies that the page number is not negative. If the page number is invalid, it throws a {@link PaginationInvalidException}.</li>
     *   <li>If the {@code sortBy} field is {@code null}, it sets it to the default value of {@code "created_at"}.</li>
     *   <li>If the {@code sortDirection} field is {@code null}, it sets it to the default value of {@code "asc"} (ascending order).</li>
     *   <li>It returns a {@link Pageable} object using the specified page number, page size, sorting field, and sorting direction.</li>
     * </ul>
     *
     * @param input The command object that contains the pagination and sorting parameters.
     * @return A {@link Pageable} object representing the requested pagination and sorting configuration.
     * @throws PaginationInvalidException If the page number is negative or otherwise invalid.
     *
     * @since 1.0.0
     */
    private Pageable createPageableWithInput(TCommand input) {
        if(input.page < 0)
            throw new PaginationInvalidException();

        if(input.sortBy == null)
            input.sortBy = "created_at";

        if(input.sortDirection == null)
            input.sortDirection = "asc";

        return PageRequest.of(
                input.page,
                input.size,
                Sort.Direction.fromString(input.sortDirection), input.sortBy);
    }

    /**
     * Retrieves a page of entities from the repository based on pagination settings.
     *
     * @param input The query containing the pagination information.
     * @param genericRepository The repository to retrieve the entities from.
     * @return A page of entities.
     *
     * @since 1.0.1
     */
    public Page<TDbEntity> retrieveEntities(TCommand input, Pageable pageable, IEntityRepository<TDbEntity> genericRepository) {
        return repository.findAll(pageable);
    }

    /**
     * Hook method that can be overridden by subclasses to perform additional actions
     * after the entities have been retrieved.
     *
     * @param entitiesDatabase The list of entities retrieved from the database.
     *
     * @since 1.0.1
     */
    public void afterEntityRetrieve(List<TDbEntity> entitiesDatabase) {}

    /**
     * Creates a new instance of the output DTO class.
     *
     * @return A new instance of the output DTO.
     * @throws RuntimeException if the output instance cannot be created.
     *
     * @since 1.0.1
     */
    private TOutput createOutputInstance() {
        try {
            return outputClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create output instance", e);
        }
    }
}

package info.toast1ng.toylostark.common.adapter.out.persistence;

public interface BasicMapper <JpaEntity, DomainEntity>{
    JpaEntity mapToJpaEntity(DomainEntity domainEntity);
    DomainEntity mapToDomainEntity(JpaEntity entity);
}

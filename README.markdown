# liferay-context-contributor
A context contributor utility which provides utility methods to access articles and article contents.

## Usage

1. Deploy liferay-context-contributor
1. Determine `uuid`, `groupId`, and `privateLayout`flag of the relevant layout, e.g.
    ```sql
    mysql> SELECT groupId, uuid_, privateLayout, friendlyURL FROM Layout;
    +---------+--------------------------------------+---------------+---------------------------------------+
    | groupId | uuid_                                | privateLayout | friendlyURL                           |
    +---------+--------------------------------------+---------------+---------------------------------------+
    |   37242 | 7948f098-a966-9495-a8a6-5bb8e2c9e14f |             1 | /manage                               |
    |   37249 | 13b89fb0-8550-1389-6674-f096ab7d0c16 |             0 | /shared                               |
    |   37249 | 15db0bab-bf53-940a-4899-d1979074c979 |             1 | /shared                               |
    |   37250 | f7faf0f2-3f2c-5cec-5e16-016bec6b5ea2 |             0 | /home                                 |
    |   37250 | e7d42a51-2408-3de7-9ae2-4d25616c9c26 |             0 | /025f652b-48c4-da82-5a9f-b0bef18726b9 |
    |   37622 | 5e20e5e2-76ab-8db5-700c-bd56abe746e0 |             1 | /layout                               |
    |   37250 | 25cfc497-db30-2fe5-bbee-dc97c4e0f746 |             0 | /search                               |
    |   37781 | 42d39904-b519-2ceb-b0b0-d17ead6cecea |             1 | /layout                               |
    |   37792 | 49abab78-e105-61e2-2b9e-d899037dca7a |             1 | /layout                               |
    +---------+--------------------------------------+---------------+---------------------------------------+
    9 rows in set (0.00 sec)
    ```
1. Select the Layout in a fragment or (Freemarker) template like: 
  ```
  <#assign homeLayout = layoutUtil.getLayout("f7faf0f2-3f2c-5cec-5e16-016bec6b5ea2", 37250, false) />
  ${homeLayout}
  ```

## Contact

christian.berndt@liferay.com

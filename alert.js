/* jshint indent: 2 */

module.exports = function (sequelize, DataTypes) {
  return sequelize.define(
    "alert_list",
    {
      alert_list_id: {
        type: DataTypes.INTEGER(11),
        allowNull: false,
        primaryKey: true,
        autoIncrement: true,
      },
      alert_id: {
        type: DataTypes.INTEGER(11),
        allowNull: false,
      },
      alert_name: {
        type: DataTypes.STRING(254),
        allowNull: false,
      },
      alert_type: {
        type: DataTypes.INTEGER(11),
        allowNull: false,
      },
      for_once: {
        type: DataTypes.STRING(100),
        allowNull: true,
      },
      is_send: {
        type: DataTypes.INTEGER(4),
        allowNull: false,
        defaultValue: 0,
      },
      alert_frequency: {
        type: DataTypes.STRING(254),
        allowNull: false,
      },
      alert_set_timestamp: {
        type: DataTypes.DATE,
        allowNull: false,
        defaultValue: sequelize.literal("CURRENT_TIMESTAMP"),
      },
      is_deleted: {
        type: DataTypes.INTEGER(4),
        allowNull: false,
        defaultValue: 0,
      },
      created_by: {
        type: DataTypes.INTEGER(11),
        allowNull: false,
      },
    },
    {
      tableName: "alert_list",
    }
  );
};
